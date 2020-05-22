String path = "path";
    String fileName = "fileName.ext";
    try (Socket socket = new Socket("localhost", port)) {
        File file = new File(path, fileName);

        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        try (DataOutputStream dos = new DataOutputStream(bos)) {                
            FileInputStream fis = new FileInputStream(file);
            try (BufferedInputStream bis = new BufferedInputStream(fis)) {
                dos.write(IOUtils.toByteArray(bis));
            }
        }
    }
    catch(Exception e) {
        e.printStackTrace();
    }