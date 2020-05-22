private static Promise<byte[]> toBytes(final File file) {
    return Promise.promise(new Function0<byte[]>() {
        @Override
        public byte[] apply() throws Throwable {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            FileInputStream is = new FileInputStream(file);

            for (int readNum; (readNum = is.read(buffer)) != -1;) {
                os.write(buffer, 0, readNum);
            }
            return os.toByteArray();
        }
    });
}