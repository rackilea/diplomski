try (DataInputStream in = new DataInputStream(new GZIPInputStream(new FileInputStream(filename), 4096))) {
        for (int i = 0; i < max; ++i) {
            long value = in.readLong();
            if (value != num + i) {
                throw new RuntimeException("unexpected value: " + value);
            }
        }
    }