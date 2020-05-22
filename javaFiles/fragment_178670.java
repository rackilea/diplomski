class SimpleJava {

    public static void open(InputStream input, OutputStream output) throws IOException {

        try {
            ObjectInputStream ois = new ObjectInputStream(input);
            System.out.println(ois.available());// 0
            System.out.println(ois.available() + " " + ois.read() + " " + ois.read());// 0 -1 -1
            // Reads the object even if the available returned 0 
            // and ois.read() returned -1
            System.out.println("object:" + ois.readObject());// object:abcd
        }
        catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

    static void open(Path path) throws IOException {

        if (path != null) {
            ByteArrayInputStream in = null;
            if (Files.exists(path)) {
                byte[] data = Files.readAllBytes(path);
                in = new ByteArrayInputStream(data);
            }
            OutputStream out = Files.newOutputStream(path);
            open(in, out);
        }
    }

    public static void main(String[] args) throws Exception {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/home/pradhan/temp.object")));
        oos.writeObject("abcd");//writes a string object for us to read later
        oos.close();
        //
        open(FileSystems.getDefault().getPath("/home/user/temp.object"));
    }
}