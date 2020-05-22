Reader reader = new FilterReader(fileReader) {

        private int filter(int ch) {
            return ch == '"'?' ':ch;
        }
        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            int red = super.read(cbuf, off, len);
            for ( int i = off; i < off + red; i++) {
                cbuf[i] = (char)filter(cbuf[i]);
            }
            return red;
        }

        @Override
        public int read() throws IOException {
            return filter(super.read());
        }

    };