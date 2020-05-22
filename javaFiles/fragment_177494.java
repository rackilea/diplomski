private static void writeBytesToFile(byte[] b, String f) {

    try (FileOutputStream out = new FileOutputStream(f)){
        out.write(b);
    }

    catch (IOException e) {
        e.printStackTrace();
    }          
}