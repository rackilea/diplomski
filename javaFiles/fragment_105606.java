try (final FileInputStream fis = new FileInputStream(file)) {

        ByteBuffer buffer = ByteBuffer.allocate(64);

        boolean wasLast = false;
        String headerValue = null, headerKey = null;
        byte[] result = null;

        while (true) {
            byte current = (byte) fis.read();
            if (current == '\n') {
                if (wasLast) {
                    // this is \n\n
                    break;
                } else {
                    // just a new line in header
                    wasLast = true;
                    headerValue = new String(buffer.array(), 0, buffer.position()));
                    buffer.clear();
                }
            } else if (current == '\t') {
                // headerKey\theaderValue\n
                headerKey = new String(buffer.array(), 0, buffer.position());
                buffer.clear();
            } else {
                buffer.put(current);
                wasLast = false;
            }
        }
        // reading the rest
        result = IOUtils.toByteArray(fis);
    }