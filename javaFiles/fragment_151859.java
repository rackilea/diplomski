public interface Ws2_32 extends Library {

    // I don't know how to declare fixed size arrays in JNA,
    // so you will have to adjust these Structue declarations
    // as needed...

    public static class WSAData extends Structure {
        short wVersion;
        short wHighVersion;
        byte  szDescription[257];
        byte  szSystemStatus[129];
        short iMaxSockets;
        short iMaxUdpDg;
        String lpVendorInfo;
    };

    public static class WSAPROTOCOLCHAIN extends Structure {
        int ChainLen;
        int ChainEntries[7];
    };

    public static class WSAPROTOCOL_INFOW extends Structure {
        int dwServiceFlags1;
        int dwServiceFlags2;
        int dwServiceFlags3;
        int dwServiceFlags4;
        int dwProviderFlags;
        GUID ProviderId;
        int dwCatalogEntryId;
        WSAPROTOCOLCHAIN ProtocolChain;
        int iVersion;
        int iAddressFamily;
        int iMaxSockAddr;
        int iMinSockAddr;
        int iSocketType;
        int iProtocol;
        int iProtocolMaxOffset;
        int iNetworkByteOrder;
        int iSecurityScheme;
        int dwMessageSize;
        int dwProviderReserved;
        char szProtocol[256];
    };

    Ws2_32 INSTANCE = (Ws2_32) Native.loadLibrary("ws2_32", Ws2_32.class);

    int WSAStartup(short version, WSADATA lpwsaData);
    int WSAEnumProtocolsW(int[] lpiProtocols, WSAPROTOCOL_INFOW[] lpProtocolBuffer, IntByReference lpdwBufferLength);
    int WSACleanup();
    int WSAGetLastError();
    int WSASetLastError(int iError);
}