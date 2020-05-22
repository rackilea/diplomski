public class TestWSAEnumProtocolsA {

    public void start(){

        WSAPROTOCOL_INFOW[]     wsaprotocol_info = new WSAPROTOCOL_INFOW[1];
        WSADATA                 wsaData = new WSADATA();
        IntByReference          dwBufferLength = new IntByReference(628); // sizeof WSAPROTOCOL_INFOW, in bytes
        int                     result = 0;
        short                   version = 2;

        if((result = Ws2_32.INSTANCE.WSAStartup(version, wsaData)) != 0){
            System.out.println("Error #" + result + " at WSAStartup()");
            return;
        }

        System.out.println("WSAStartup() finished correctly.");

        if((result = Ws2_32.INSTANCE.WSAEnumProtocolsW(null, wsaprotocol_info, dwBufferLength)) == -1){
            System.out.println("WSAEnumProtocolsW() returned: " + result);
            System.out.println("dwBufferLength is: " + dwBufferLength.getValue());
            System.out.println("WSAGetLastError() returned: " + Ws2_32.INSTANCE.WSAGetLastError());
        }
    }
}