public class Usb_Communciation {
    public final static int USBAccessoryWhat = 0;
    public int firmwareProtocol = 0;
    public static USBAccessoryManager accessoryManager;
    public static String TAG = "MICROCHIP";
    public static final int APP_CONNECT                 = (int)0xAE;
    public boolean deviceAttached = false;


    public Usb_Communciation (/*Pass neccesary parameters here from activity*/) {
       accessoryManager = new USBAccessoryManager(handler, USBAccessoryWhat);
    }


    public void Send_message(byte[] data) {
       try{
           accessoryManager.write(data);
       }catch (Exception e){
          Log.d(TAG,
                "USBAccessoryManager:write():IOException: arasu "
                        + e.toString());
        e.printStackTrace();
       }
   }

   public Handler handler = new Handler() {
       @Override
       public void handleMessage(Message msg) {
           byte[] commandPacket = new byte[64];
           byte[] WriteValue = new byte[2];

           switch(msg.what)
           {
            case USBAccessoryWhat:
                boolean StopReading = true;
                int count = 0;
                switch(((USBAccessoryManagerMessage)msg.obj).type)
                {
                    case READ:
                        if(accessoryManager.isConnected() == false) {
                            return;
                        }
                        while(true) {
                            if (accessoryManager.available() < 2) {
                                break;
                            }
                        }
                        break;
                    case READY:
                        String version = ((USBAccessoryManagerMessage)msg.obj).accessory.getVersion();
                        firmwareProtocol = getFirmwareProtocol(version);
                        switch(firmwareProtocol){
                            case 1:
                                deviceAttached = true;
                                break;
                            case 2:
                                deviceAttached = true;
                                commandPacket[0] = (byte) APP_CONNECT;
                                commandPacket[1] = 0;
                                accessoryManager.write(commandPacket);                                  
                                Log.d(TAG,"connect message sent.");
                                break;
                        }
                        break;
                }
                break;
        }   //switch
    } //handleMessage
}; //handler

   public int getFirmwareProtocol(String version) {
       String major = "0";
       int positionOfDot;
       positionOfDot = version.indexOf('.');
       if(positionOfDot != -1) {
        major = version.substring(0, positionOfDot);
    }
    return new Integer(major).intValue();
}