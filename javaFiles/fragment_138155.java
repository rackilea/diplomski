DefaultHttpClient httpclient = new DefaultHttpClient();
try {
   HttpPost httppost = new HttpPost("http://www.google.com/sorry");

   MultipartEntity outentity = new MultipartEntity() {

    @Override
    public void writeTo(final OutputStream outstream) throws IOException {
        super.writeTo(new CoutingOutputStream(outstream));
    }

   };
   outentity.addPart("stuff", new StringBody("Stuff"));
   httppost.setEntity(outentity);

   HttpResponse rsp = httpclient.execute(httppost);
   HttpEntity inentity = rsp.getEntity();
   EntityUtils.consume(inentity);
} finally {
    httpclient.getConnectionManager().shutdown();
}

static class CoutingOutputStream extends FilterOutputStream {

    CoutingOutputStream(final OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        System.out.println("Written 1 byte");
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
        System.out.println("Written " + b.length + " bytes");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        System.out.println("Written " + len + " bytes");
    }

}