/**
     * Convert InputStream into String
     * @param is
     * @return
     * @throws IOException Throws an IO Exception if input stream cannot be read
     */
    public static String stringFromInputStream(InputStream is) throws IOException {
        if (is != null) {
            byte[] bytes = new byte[1024];
            StringBuilder x = new StringBuilder();
            int numRead = 0;
            while ((numRead = is.read(bytes)) >= 0) 
                x.append(new String(bytes, 0, numRead));
            return x.toString();
        }
        else {
            return "";
        }
    }