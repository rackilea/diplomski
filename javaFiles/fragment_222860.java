@Bean
@Transformer(inputChannel = "gUnzipIt", outputChannel = "gUnzipped")
public byte[] gUnzip(byte[] in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    GZIPInputStream gzIn = new GZIPInputStream(new ByteArrayInputStream(in));
    FileCopyUtils.copy(gzIn, out);
    return out.toByteArray();
}