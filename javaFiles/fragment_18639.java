public static void main(String[] args) throws IOException {
    ZipFile zipFile = new ZipFile("C:/Test/Test.zip");
    Enumeration<? extends ZipEntry> entries = zipFile.entries();

    while(entries.hasMoreElements()){
        ZipEntry entry = entries.nextElement();
        System.out.println(entry.getName());
        InputStream stream = zipFile.getInputStream(entry);

        //For characters
        //BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        BufferedInputStream reader = new BufferedInputStream(stream);
        //For line reading
        //System.out.println(reader.readLine());
        int byteRead = reader.read();
        while(byteRead != -1) {
            System.out.println(byteRead);
            byteRead = reader.read();
        }

    }
}