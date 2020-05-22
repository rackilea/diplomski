public List<Long> simpleApproach(InputStream pdf) throws IOException {
    StreamSearcher streamSearcher = new StreamSearcher("%%EOF".getBytes());
    List<Long> results = new ArrayList<>();
    long revisionSize = 0;
    long diff;
    while ((diff = streamSearcher.search(pdf)) > -1) {
        revisionSize += diff;
        results.add(revisionSize);
    }
    return results;
}