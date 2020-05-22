public static void main(String[] args) throws UnsupportedEncodingException, IOException {
    final File corpusFile = new File("corpus");
    final String corpusFileContent = readFileToString(corpusFile);
    final File file = new File("myEngramFile");
    try (final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            final int matches = countOccurencesOf(line, corpusFileContent);
        };
    }
}

private static String readFileToString(final File file) throws IOException {
    final StringBuilder stringBuilder = new StringBuilder();
    try (final FileChannel fc = new RandomAccessFile(file, "r").getChannel()) {
        final ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        final CharsetDecoder charsetDecoder = Charset.forName("UTF-8").newDecoder();
        while (fc.read(byteBuffer) > 0) {
            byteBuffer.flip();
            stringBuilder.append(charsetDecoder.decode(byteBuffer));
            byteBuffer.reset();
        }
    }
    return stringBuilder.toString();
}

private static int countOccurencesOf(final String countMatchesOf, final String inString) {
    final Matcher matcher = Pattern.compile("\\b" + countMatchesOf + "\\b").matcher(inString);
    int count = 0;
    while (matcher.find()) {
        ++count;
    }
    return count;
}