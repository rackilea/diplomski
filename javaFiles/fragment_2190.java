public class Main {
    public static void main(String[] args) {
        try {
            byte[] bytes = getBytes("MeasurePrinter.class", "~/BundleSensorAlarmLib.jar");
            System.out.println(bytesToHex(bytes));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static byte[] getBytes(String javaFileName, String jar) throws IOException {
        // ... inputs check omitted ...
        try (JarFile jarFile = new JarFile(jar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();

                // We are only interested in .class files spawned by compiling the argument file.
                if (entry.getName().endsWith(".class") &&
                        entry.getName().contains(javaFileName.substring(0, javaFileName.lastIndexOf(".")))) {
                    try (InputStream inputStream = jarFile.getInputStream(entry)) {
                        return getBytes(inputStream);
                    } catch (IOException ioException) {
                        System.out.println("Could not obtain class entry for " + entry.getName());
                        throw ioException;
                    }
                }
            }
        }
        throw new IOException("File not found");
    }

    private static byte[] getBytes(InputStream is) throws IOException {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();)
        {
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = is.read(buffer)) != -1;)
                os.write(buffer, 0, len);
            os.flush();
            return os.toByteArray();
        }
    }

    private static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}