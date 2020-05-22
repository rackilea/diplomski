try (DataInputStream in = new DataInputStream(new GZIPInputStream(new FileInputStream(filename), 4096))) {
        byte[] buf = new byte[Long.BYTES];
        for (int i = 0; i < max; ++i) {
            in.readFully(buf);
            long value = bytes2long(buf);
            if (value != num + i) {
                throw new RuntimeException("unexpected value: " + value);
            }
        }
    }