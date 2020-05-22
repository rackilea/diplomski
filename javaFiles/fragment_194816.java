public static String decompress(byte [] data) throws IOException {
    try (
        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {

        int read;
        byte [] buff = new byte[1024];
        while((read = gis.read(buff)) != -1) {
            out.write(buff, 0, read);
        }

        return out.toString("UTF-8");
    }
}