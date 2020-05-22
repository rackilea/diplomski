@Bean
@Transformer(inputChannel = "gzipIt", outputChannel = "gzipped")
public byte[] gzip(byte[] in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPOutputStream gzOut = new GZIPOutputStream(out);
    FileCopyUtils.copy(in, gzOut);
    return out.toByteArray();
}