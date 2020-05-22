private static final String WINDOWS_NT_SYTEM_TYPE = "Windows_NT";
   ....
   ....
    try {
            String res = client.getSystemType();
            if (res.equals(WINDOWS_NT_SYTEM_TYPE)) {
                client.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            } else {
                client.setFileTransferMode(FTP.BLOCK_TRANSFER_MODE);
            }
        }