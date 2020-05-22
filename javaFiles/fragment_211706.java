public static String unzip(InputStream in) 
            throws IOException, CompressorException, ArchiveException {
        System.out.println("Unzipping.............");
        try (
            GZIPInputStream gzis = new GZIPInputStream(in);
            InputStreamReader reader = new InputStreamReader(gzis);
            BufferedReader br = new BufferedReader(reader);
        ) {
            int ch;
            long i = 0;
            while ((ch = br.read()) >= 0) {
                 i++;
                 if (i % (100 * 1024 * 1024) == 0) {
                     System.out.println(i / (1024 * 1024));
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Invoked AWSUtils getS3Content : json ", e);
        }