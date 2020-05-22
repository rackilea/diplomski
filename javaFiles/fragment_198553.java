private void handleFileUpload(String fileSizeInBytes, String fileName) throws IOException{
        String fullyQualifiedFileName = rootDirectory+System.getProperty("file.separator")+fileName;
        File fileToWrite = new File(fullyQualifiedFileName);
        if(fileToWrite.exists()){
            fileToWrite.delete();
        }

        int bytesRead = 0;
        byte[] aByte = new byte[1024];
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            inputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(fullyQualifiedFileName);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bytesRead = inputStream.read(aByte, 0, aByte.length);
            while (bytesRead != -1) {
                bufferedOutputStream.write(aByte, 0, bytesRead);
                bytesRead = inputStream.read(aByte, 0, aByte.length);
            } 

            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }