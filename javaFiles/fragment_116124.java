import java.io.*; 
import java.util.*; 
import gnu.io.*; 

public class SMSsender { 
static Enumeration portList; 
static CommPortIdentifier portId; 
static String messageString1 = "AT";
static String messageString2 = "AT+CPIN=\"7078\"";
static String messageString3 = "AT+CMGF=1"; 
static String messageString4 = "AT+CMGS=\"+4866467xxxx\"";


static String messageString5 = "TESTY2";
static SerialPort serialPort;
static OutputStream outputStream;
static InputStream inputStream;
static char enter = 13;

static char CTRLZ = 26;
public static void main(String[] args) throws InterruptedException {
 portList = CommPortIdentifier.getPortIdentifiers();



while (portList.hasMoreElements()) {

    portId = (CommPortIdentifier) portList.nextElement();
    if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

         if (portId.getName().equals("COM3")) {

            try {
                serialPort = (SerialPort)
                    portId.open("COM3", 2000);
            } catch (PortInUseException e) {System.out.println("err");}
            try {
                outputStream = serialPort.getOutputStream();
                inputStream = serialPort.getInputStream();
            } catch (IOException e) {e.printStackTrace();}
            try {
                serialPort.setSerialPortParams(9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE); 
            } catch (UnsupportedCommOperationException e) {e.printStackTrace();}
            try { 

                outputStream.write((messageString1 + enter).getBytes());


                Thread.sleep(100); 
                outputStream.flush();

                outputStream.write((messageString2 + enter).getBytes()); 

                 Thread.sleep(100); 
                 outputStream.flush();

                outputStream.write((messageString3 + enter).getBytes());

                Thread.sleep(100); 
                outputStream.flush(); 




                outputStream.write((messageString4 + enter).getBytes()); 

                Thread.sleep(100);  
                outputStream.flush();

               outputStream.write((messageString5 + CTRLZ).getBytes());  

                outputStream.flush(); 
                Thread.sleep(100); 


    System.out.println("Wyslano wiadomosc");  
    Thread.sleep(3000);


    outputStream.close();
    serialPort.close();
    System.out.println("Port COM zamkniety"); 

            } catch (IOException e) {e.printStackTrace();}
        }
    }
}