public class serialRobot {

        public static void main(String[] s) {
                SerialPort serialPort = null;
                try {
                        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM71");
                        if (portIdentifier.isCurrentlyOwned()) {
                                System.out.println("Port in use!");
                        } else {
                                System.out.println(portIdentifier.getName());

                                serialPort = (SerialPort) portIdentifier.open(
                                                "ListPortClass", 300);
                                int b = serialPort.getBaudRate();
                                System.out.println(Integer.toString(b));
                                serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8,
                                                SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                                serialPort.setInputBufferSize(65536);
                                serialPort.setOutputBufferSize(4096);

                                System.out.println("Opened " + portIdentifier.getName());

                                OutputStream mOutputToPort = serialPort.getOutputStream();
                                InputStream mInputFromPort = serialPort.getInputStream();


                                PerpetualThread t = readAndPrint(mInputFromPort);

                                inputAndSend(mOutputToPort);


                                t.stopRunning();

                                mOutputToPort.close();
                                mInputFromPort.close();
                        }
                } catch (IOException ex) {
                        System.out.println("IOException : " + ex.getMessage());
                } catch (UnsupportedCommOperationException ex) {
                        System.out.println("UnsupportedCommOperationException : " + ex.getMessage());
                } catch (NoSuchPortException ex) {
                        System.out.println("NoSuchPortException : " + ex.getMessage());
                } catch (PortInUseException ex) {
                        System.out.println("PortInUseException : " + ex.getMessage());
                } finally {
                        if(serialPort != null) {
                                serialPort.close();
                        }
                }

        }

        private static PerpetualThread readAndPrint(InputStream in) {
                final BufferedInputStream b = new BufferedInputStream(in);
                PerpetualThread thread = new PerpetualThread() {

                        @Override
                        public void run() {
                                byte[] data = new byte[16];
                                int len = 0;
                                for(;isRunning();) {
                                        try {
                                                len = b.read(data);
                                        } catch (IOException e) {
                                                e.printStackTrace();
                                        }
                                        if(len > 0) {
                                                System.out.print(new String(data, 0, len));
                                        }
                                }
                        }

                };

                thread.start();

                return thread;
        }

        private static void inputAndSend(OutputStream out) {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                int k = 0;
                for(;;) {

                        String komanda;
                        try {
                                komanda = in.readLine();
                        } catch (IOException e) {
                                e.printStackTrace();
                                return;
                        }
                        komanda = komanda.trim();

                        if(komanda.equalsIgnoreCase("end"))       return;

                        byte komandaSiust[] = proces(komanda); //Command we send after first 

//connection, it's byte array where 0 member is the letter that describes type of command, next two members 

// is about left wheel speed, and the last two - right wheel speed.



                        try {
                               if(k == 0){
                                String siunc = "P,0,0\n"; // This command must be sent first time, when robot is connected, otherwise other commands won't work
                                ByteBuffer bb = ByteBuffer.wrap(siunc.getBytes("UTF-8"));
                                bb.order(ByteOrder.LITTLE_ENDIAN);
                                out.write(bb.array());
                                out.flush();      
                               }else{
                               ByteBuffer bb = ByteBuffer.wrap(komandaSiust);
                               bb.order(ByteOrder.LITTLE_ENDIAN);
                               out.write(bb.array());
                               out.flush();
                               }
                               k++;

                        } catch (IOException e) {
                                e.printStackTrace();
                                return;
                        }
                }
        }

        private static byte[] proces(String tekstas){
            tekstas = tekstas.trim();
            char[] charArray = tekstas.toCharArray();
            byte kodas1[];



            int fComa = tekstas.indexOf(',', 1);
            int sComa = tekstas.indexOf(',', 2);
            int matavimas = charArray.length;
            int skir1 = sComa - fComa - 1;
            int skir2 = matavimas - sComa -1;

            char leftSpeed[] = new char[skir1];

            for(int i = 0; i < skir1; i++){
                  leftSpeed[i] = charArray[fComa + i + 1];
            }

            char rightSpeed[] = new char[skir2];

            for(int i = 0; i < skir2; i++){
                rightSpeed[i] = charArray[sComa + i + 1];
            }
            String right = String.valueOf(rightSpeed);
            String left = String.valueOf(leftSpeed);


            int val1 = Integer.parseInt(left);
            int val2 = Integer.parseInt(right);
            kodas1 = new byte[5];
            kodas1[0] = (byte)-charArray[0];
            kodas1[1] = (byte)(val1 & 0xFF);
            kodas1[2] = (byte)(val1 >> 8);
            kodas1[3] = (byte)(val2 & 0xFF);
            kodas1[4] = (byte)(val2 >> 8);

            return kodas1;


        }

        private static class PerpetualThread extends Thread {
                private boolean isRunning = true;

                public boolean isRunning() {    return isRunning;       }

                public void stopRunning()       {
                        isRunning = false;
                        this.interrupt();
                }
        }
}