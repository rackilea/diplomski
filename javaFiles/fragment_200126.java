public static void writeFile(String fileName, String encoding,
            String payload) {
        boolean needGzip = payload.getBytes(Charset.forName(encoding)).length > gzipZize;
        File output = needGzip ? new File(fileName + ".gz")
                : new File(fileName);
        try (OutputStream stream = needGzip ? new GZIPOutputStream(
                new FileOutputStream(output)) : new FileOutputStream(output);
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(stream, encoding))) {
            writer.write(payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }