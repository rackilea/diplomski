// This is the NXT Mac Address. Each device has a specific Mac. Find it in the Build output when uploading
    // your NXT app to the brick using a USB cable. MUST USE USB CABLE TO SEE MAC ADDRESS!
    final String nxtMac = "00:16:53:05:3C:F5";
    //Important: This is the data stream used to communicate with the NXT.
    private DataOutputStream nxtDos = null;
    BluetoothAdapter localAdapter;
    BluetoothSocket nxtSocket;
    boolean success = false;