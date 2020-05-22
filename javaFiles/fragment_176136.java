private void saveFile(Socket socket, File receivingFile) {
        try {
            FileOutputStream wr = new FileOutputStream(receivingFile);
            byte[] buffer = new byte[socket.getReceiveBufferSize()];
            int bytesReceived = 0;

            while ((bytesReceived = socket.getInputStream().read(buffer)) > 0) {
                wr.write(buffer, 0, bytesReceived);
            }
            wr.close();
            setLogMessege("SaveFile", "File Written");
            socket.close();
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(AcceptCameraImages.class.getName()).log(Level.SEVERE, null, ex);
            }
            setLogMessege("SaveFile", e.getMessage());
        }`enter code here`