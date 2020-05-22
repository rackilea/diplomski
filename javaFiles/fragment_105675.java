final FileTransferManager manager = new FileTransferManager(connection); //Use your xmpp connection
manager.addFileTransferListener(new FileTransferListener() {
    public void fileTransferRequest(FileTransferRequest request) {
            IncomingFileTransfer transfer = request.accept();
            try {
                InputStream input = transfer.recieveFile();
                //This will be a binary stream and you can process it. Create image and display it inline in your chat app.
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    }