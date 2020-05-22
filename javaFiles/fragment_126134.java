public static void main(String[] args) throws IOException {     
        File source = new File("Test");
        File target = new File("Test/subfolder");
        copyDirectory(source, target);
    }
    public static void copyDirectory(File sourceLocation, File targetLocation)
            throws IOException {

        String[] children = sourceLocation.list();
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }
            for (int i = 0; i < children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]), new File(
                        targetLocation, children[i]));
            }
        } else {
            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);
            byte[] buf = new byte[1];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
            in.close();
            out.close();

        }
    }