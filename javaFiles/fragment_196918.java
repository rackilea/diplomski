byte[] keyBytes = (byte[]) AccessController.doPrivileged(new PrivilegedAction<Object>() {
    public Object run() {
        try {
            File f = new File("<path>\\private.der");
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            byte[] keyBytes = new byte[(int) f.length()];
            dis.readFully(keyBytes);
            dis.close();

            return keyBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
});