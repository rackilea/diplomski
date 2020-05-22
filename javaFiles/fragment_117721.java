public class MyCustomRequestHandler extends ExtractingRequestHandler {
@Override
    public void handleRequestBody(SolrQueryRequest originalReq, SolrQueryResponse rsp) throws Exception {

    Iterable<ContentStream> streams = originalReq.getContentStreams();
    ContentStream theStream = streams.iterator().next();
    InputStream is = theStream.getStream();

    //stream is an XML so parse it to a Document. I used the XOM library for this
    Document doc = parser.build(is)

    //process accordingly:
    // 1. Convert the <meta> tags to a Map<String, String>
    SolrParams extractedSolrParams = new MapSolrParams(/*Map<String, String> of all <meta> fields in GSA feed */);
    // 2. Take <content> and pass it to decodeUncompress() 
    byte[] decodedUncompressedContent = decodeUncompress(/* <content> from gsa feed*/) 

 //Once the parsing and processing is complete, construct a new solr request
      LocalSolrQueryRequest localRequest = new LocalSolrQueryRequest(originalReq.getCore(), extractedSolrParams);
     List<ContentStream> newContentStreams = new ArrayList<ContentStream>();
        newContentStreams.add(new ContentStreamBase.ByteArrayStream(decodedUncompressedContent, "GSA Feed <content>"));
        localRequest.setContentStreams(newContentStreams);

     super.handleRequestBody(localRequest, rsp);
  }

private byte[] decodeUncompress(byte[] data) throws IOException {
        // Decode
        byte[] decodedBytes = Base64.getDecoder().decode(data);

        // Uncompress
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Inflater decompresser = new Inflater(false);
        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(stream, decompresser);
        try {
            inflaterOutputStream.write(decodedBytes);

        } catch (IOException e) {
            throw e;
        } finally {
            try {
                inflaterOutputStream.close();
            } catch (IOException e) {
            }
        }
        return stream.toByteArray();
    }
}