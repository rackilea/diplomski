public static AbstractHttpEntity getCompressedEntity(byte data[], ContentResolver resolver)
        throws IOException {
    AbstractHttpEntity entity;
    if (data.length < getMinGzipSize(resolver)) {
        entity = new ByteArrayEntity(data);
    } else {
        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        OutputStream zipper = new GZIPOutputStream(arr);
        zipper.write(data);
        zipper.close();
        entity = new ByteArrayEntity(arr.toByteArray());
        entity.setContentEncoding("gzip");
    }
    return entity;
}