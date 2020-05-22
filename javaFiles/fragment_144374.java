private StreamResource getPDFStream() {
        StreamResource.StreamSource source = new StreamResource.StreamSource() {

            public InputStream getStream() {
                // return your file/bytearray as an InputStream
                  return input;

            }
        };
      StreamResource resource = new StreamResource ( source, getFileName());
        return resource;
}