public TwoWaySerialComm()
{
    super();
}

static boolean bReadyToSend = false;

void connect ( String portName ) throws Exception
{
    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
    if ( portIdentifier.isCurrentlyOwned() )
    {
        System.out.println("Error: " + portName + " is currently in use.");
    }
    else
    {
        CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

        if ( commPort instanceof SerialPort )
        {
            SerialPort serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_7, SerialPort.STOPBITS_1, SerialPort.PARITY_EVEN);

            InputStream in = serialPort.getInputStream();
            OutputStream out = serialPort.getOutputStream();

            // Thread handling logic
            // https://www.javaspecialists.eu/archive/Issue056.html
            Thread readThread = new Thread(new SerialReader(in));
            readThread.start();
            Thread writeThread = new Thread(new SerialWriter(out));
            writeThread.start();

            // Running threads for 10 seconds then stopping to ensure threads are shutting down
            long threadCurrTime = System.currentTimeMillis();
            long threadStartTime = System.currentTimeMillis();
            while( (threadCurrTime - threadStartTime) < 10000)
            {
                try 
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(TwoWaySerialComm.class.getName()).log(Level.SEVERE, null, ex); 
                }
                threadCurrTime = System.currentTimeMillis();
            }

            if(writeThread.isAlive())
            {
                //System.out.println("Sending interrupt to SerialWriter thread...");
                writeThread.interrupt();
                writeThread.join();
                //System.out.println("SerialWriter thread is shut down.");
            }
            //else
            //{
            //    System.out.println("SerialWriter thread is already shut down.");
            //}

            if(readThread.isAlive())
            {
                //System.out.println("Sending interrupt to SerialReader thread...");
                readThread.interrupt();
                readThread.join();
                //System.out.println("SerialReader thread is shut down.");
            }
            //else
            //{
            //    System.out.println("SerialReader thread is already shut down.");
            //}

            commPort.close();
        }
        else
        {
            System.out.println("Error: " + portName + " is not recognized as a valid serial device.");
        }
    }     
}

/* SerialReader thread logic */
public static class SerialReader implements Runnable 
{
    InputStream in;
    boolean bShuttingDown = false;

    public SerialReader ( InputStream in )
    {
        this.in = in;
    }

    public void run ()
    {
        byte[] RecvString = new byte[12];
        String strResponse;
        int len = -1;
        try
        {
            while (!bShuttingDown)
            {
                len = this.in.read(RecvString);

                if( len > -1 )
                {
                    strResponse = "";
                    if(RecvString[0] == 0x02 && RecvString[9] == 0x03)
                    {
                        if(RecvString[3] == 0x00 && RecvString[4] == 0x00 && RecvString[5] == 0x00 && RecvString[6] == 0x00)
                        {
                            strResponse = "Device not ready.";
                        }
                        else
                        {
                            //-- RecvString[3]------------------
                            if(RecvString[3] == 0x01)
                                strResponse = " - Idling";
                            else
                            if(RecvString[3] == 0x02)
                                strResponse = " - Accepting";
                            else
                            if(RecvString[3] == 0x04)
                            {
                                strResponse = " - Escrowed";

                                if(RecvString[5] == 0x08)
                                    strResponse += " $1";
                                else
                                if(RecvString[5] == 0x10)
                                    strResponse += " $2";
                                else
                                if(RecvString[5] == 0x18)
                                    strResponse += " $5";
                                else
                                if(RecvString[5] == 0x20)
                                    strResponse += " $10";
                                else
                                if(RecvString[5] == 0x28)
                                    strResponse += " $20";
                                else
                                    strResponse += " unrecognized bill inserted";
                            }
                            else
                            if(RecvString[3] == 0x08)
                                strResponse = " - Stacking";
                            else
                            if(RecvString[3] == 0x10)
                                strResponse = " - Stacked";
                            else
                            if(RecvString[3] == 0x11)
                                strResponse = " - Returning";
                            else
                            if(RecvString[3] == 0x12)
                                strResponse = " - Returned";

                            //-- RecvString[4]------------------
                            if(RecvString[4] == 0x01)
                                strResponse += " - Cheated";
                            else
                            if(RecvString[4] == 0x02)
                                strResponse += " - Rejected";
                            else
                            if(RecvString[4] == 0x04)
                                strResponse += " - Jammed";
                            else
                            if(RecvString[4] == 0x08)
                                strResponse += " - Bill Stacker Full";
                            else
                            if(RecvString[4] == 0x10)
                                strResponse += " - Removable Cassette Installed";
                            else
                            if(RecvString[4] == 0x11)
                                strResponse += " - Reserved";
                            else
                            if(RecvString[4] == 0x12)
                                strResponse += " - Calibration mode";

                            //-- RecvString[5]------------------
                            if(RecvString[5] == 0x01)
                                strResponse += " - Power Up Reset";
                            else
                            if(RecvString[5] == 0x02)
                                strResponse += " - Invalid Command";
                            else
                            if(RecvString[5] == 0x04)
                                strResponse += " - Non-recoverable fault";
                        }
                        if(!strResponse.contains("Idling"))
                            System.out.println("Recv: " + DatatypeConverter.printHexBinary(RecvString) + strResponse);
                    }
                    else
                    {
                        System.out.println("Recv (invalid): " + DatatypeConverter.printHexBinary(RecvString));
                    }

                    try
                    {
                        Thread.sleep(100); // need this delay before we send next polling message, otherwise the data doesn't come in correctly
                        bReadyToSend = true;
                    }
                    catch (InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                        //System.out.println("Shut down SerialReader thread.");
                        bShuttingDown = true;
                        break;
                    }
                }
            }
        }
        catch ( IOException ex )
        {
            System.out.println("Recv exception: " + ex.toString());
        }            
    }
}

/* SerialWriter thread logic */
public static class SerialWriter implements Runnable 
{
    OutputStream out;
    long lastSendTime = System.currentTimeMillis() - 1001;
    long currSendTime;
    byte[] SendString = new byte[8];
    byte CheckDigit;
    int iSendStringCount;
    boolean bOddCount = true;
    boolean bShuttingDown = false;

    public SerialWriter ( OutputStream out )
    {
        this.out = out;
    }

    public void run ()
    {
        while(!bShuttingDown)
        {
            currSendTime = System.currentTimeMillis();
            if(currSendTime - lastSendTime > 1000) // if it's been more than a second, send query string
                bReadyToSend = true;

            if(bReadyToSend)
            {
                SendString[0] = (byte) 0x02; //STX
                SendString[1] = (byte) 0x08;
                if(bOddCount)
                {
                    SendString[2] = (byte) 0x10;
                    bOddCount = false;
                }
                else
                {
                    SendString[2] = (byte) 0x11;
                    bOddCount = true;
                }
                SendString[3] = (byte) 0x7F;
                SendString[4] = (byte) 0x1C;
                SendString[5] = (byte) 0x00;
                SendString[6] = (byte) 0x03; //ETX

                //CheckDigit skips STX (byte 0) with byte 1 as seed/initial value
                //To calculate the check digit, start with next byte (2)
                CheckDigit = SendString[1];
                iSendStringCount = 2;
                while(SendString[iSendStringCount] != 0x03)
                {
                    CheckDigit = (byte) (SendString[iSendStringCount]^CheckDigit); //XOR current CheckDigit value with next byte
                    iSendStringCount++;
                }
                iSendStringCount++; //advance one more so we don't overwrite ETX
                SendString[iSendStringCount] = (byte) CheckDigit;

                try
                {
                    lastSendTime = System.currentTimeMillis();
                    this.out.write(SendString);
                    //System.out.println("Sent: " + DatatypeConverter.printHexBinary(SendString));
                }
                catch ( IOException ex )
                {
                    System.out.println("Send exception: " + ex.toString());
                }

                try
                { 
                    Thread.sleep(1); // this is hear simply to catch an external interrupt
                }
                catch (InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                    //System.out.println("Shut down SerialWriter thread.");
                    bShuttingDown = true;
                    break;
                }
                bReadyToSend = false;
            }
        }
    }
}

public static void main ( String[] args )
{
    try
    {
        System.out.println("*****************************");
        System.out.println("*****  Starting Program *****");
        System.out.println("*****************************");

        String strUsbDeviceDir = "/dev/serial/by-id";
        File myUsbDeviceDir = new File(strUsbDeviceDir);
        if(myUsbDeviceDir.exists())
        {
           String[] myUsbDevices = myUsbDeviceDir.list();
           for(int i=0; i<myUsbDevices.length; i++)
           {
               if(myUsbDevices[i].contains("EBDS_over_USB"))
               {
                   File tempFile = new File(strUsbDeviceDir + "/" + myUsbDevices[i]);
                   String usbCanonicalName = tempFile.getCanonicalFile().toString(); //gives me /dev/ttyUSBx where 'x' is the USB device number
                   System.out.println("Connecting to " + usbCanonicalName + " (" + myUsbDevices[i] + ")");
                   (new TwoWaySerialComm()).connect(usbCanonicalName);
               }
               else
               {
                   System.out.println("Not using " + myUsbDevices[i]);
               }
           }
        }
    }
    catch ( Exception ex )
    {
        System.out.println("Connect exception: " + ex.toString());
    }

    System.out.println("*****************************");
    System.out.println("***** Program Finished ******");
    System.out.println("*****************************");
}