public void testReadCamera() throws IOException {
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        FileInputStream is = new FileInputStream(new File(dir, "Camera/IMG_20140623_125853.jpg"));
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        int b = 0; // This has to be an int, return type of FileInputStream.read() is int
        while((b = is.read()) != -1) { // I was casting to byte here... I still wonder why myself...
            bytes.add((byte)b); //Here is where the cast should have been.
        }
        byte[] data = new byte[bytes.size()];
        for(int i = 0; i < bytes.size(); i++){
            data[i] = bytes.get(i);
        }

        assertEquals(file.length(), data.length); // Also...

}