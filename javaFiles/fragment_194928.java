public static boolean isBinary(String fileName) throws IOException {
        return isBinary(new File(fileName));
    }

    public static boolean isBinary(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        try {
            byte[] buf = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buf)) >= 0)
            {
                for (int i = 0; i < bytesRead; i++) {
                    if (buf[i] == (byte) 0)
                        return true;
                }
            }

            return false;
        } finally {
            is.close();
        }
    }