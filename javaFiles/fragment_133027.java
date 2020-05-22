// With 'gzip' being the compressed buffer
java.io.ByteArrayInputStream bytein = new java.io.ByteArrayInputStream(gzip);
java.util.zip.GZIPInputStream gzin = new java.util.zip.GZIPInputStream(bytein);
java.io.ByteArrayOutputStream byteout = new java.io.ByteArrayOutputStream();

int res = 0;
byte buf[] = new byte[1024];
while (res >= 0) {
    res = gzin.read(buf, 0, buf.length);
    if (res > 0) {
        byteout.write(buf, 0, res);
    }
}
byte uncompressed[] = byteout.toByteArray();