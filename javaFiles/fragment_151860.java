public static void main(String[] args){
    WSADATA     wsaData = new WSADATA();
    short       version = 2;
    int         result = Ws2_32.INSTANCE.WSAStartup(version, wsaData);

    System.out.println("WSAStartup() returned: " + result);

    if(result == 0){
        System.out.println("WSADATA struct:");
        System.out.println("wVersion: " + wsaData.wVersion);
        System.out.println("wHighVersion: " + wsaData.wHighVersion);

        System.out.print("szDescription: ");
        for(byte b : wsaData.szDescription){
            System.out.print((char) b);
        }
        System.out.print("\n");

        System.out.print("szSystemStatus: ");
        for(byte b : wsaData.szSystemStatus){
            System.out.print((char) b);
        }
        System.out.print("\n");

        System.out.println("iMaxSockets: " + wsaData.iMaxSockets);
        System.out.println("iMaxUdpDg: " + wsaData.iMaxUdpDg");
    }
}