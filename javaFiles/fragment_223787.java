public class MainClass{
private static MyProtocol myProt = new MyProtocol();
    public static byte[] message = new byte[50];
    public boolean newMessage = false;
    private boolean runApp = true;
    public int newColectors = 0;
    private static final int START_OF_MESAGE = 100;


    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyAMA0"); 
        MainClass myApp = new MainClass();

        while(myApp.runApp){
            if(myApp.checkMessageReceived()){
                myProt.processMessage(message);
                myProt.sendAcknowledge();
            }
            myApp.findNewCollectors();

            try { Thread.sleep(2000); } catch (InterruptedException ie) {}
        }
    }

    public boolean checkMessageReceived(){
        if(message[0]== (byte) START_OF_MESAGE){
            newMessage = true;
        }
        return newMessage;
    }