public LimitExceededException extends IOException { ... }

    public class LimitingOutputStream extends FilterOutputStream {
        private int limit;
        private int count;

        public LimitingOutputStream(OutputStream out, int limit) {
            super(out);
            this.limit = limit;
        }

        @Override
        public void write(byte b) throws IOException {
            if (count++ > limit) {
                throw LimitExceededException(...);
            }
            super.write(b);
        }

        @Override
        // (This override is not strictly necessary, but it makes it faster)
        public void write(byte[] bytes, int from, int size) throws IOException {
            if (count += size > limit) {
                throw LimitExceededException(...);
            }
            super.write(bytes, from, size);
        }
    }

    /**
     * Return the serialization of `o` in a byte array, provided that it is
     * less than `limit` bytes.  If it is too big, return `null`.
     */
    public byte[] serializeWithLimit(Object o, int limit) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            LimitingOutputStream los = new LimitingOutputStream(bos, limit);
            ObjectOutputStream oos = new ObjectOutputStream(los);
            oos.writeObject(o);
            oos.close();
            return bos.toByteArray(); 
        } catch (LimitExceededException e) {
            return null;
        }
    }