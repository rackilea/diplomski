public static void main(String[] args) throws Exception {
        Connection conn = new Connection(hostname);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username, password);

        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");
        SFTPv3Client client = new SFTPv3Client(conn);
        File tmpFile = File.createTempFile("teststackoverflow", "dat");
        FileWriter fw = new FileWriter(tmpFile);
        fw.write("this is a test");
        fw.flush();
        fw.close();

        SFTPv3FileHandle handle = client.createFile(tmpFile.getName());
        FileInputStream fis = new FileInputStream(tmpFile); 
        byte[] buffer = new byte[1024];
        int i=0;
                    long offset=0;
        while ((i = fis.read(buffer)) != -1) {
            client.write(handle,offset,buffer,0,i);
                            offset+= i;

        }
        client.closeFile(handle);
        if (handle.isClosed())  System.out.println("closed");;
        client.close();
}