public static <T extends CharSequence & Appendable> IAppendableCharSequence wrap(T t) {
    if (t == null) throw new NullPointerException();
    final CharSequence csq = t;
    final Appendable a = t;
    return new IAppendableCharSequence() {
        @Override
        public int length() {
            return csq.length();
        }

        @Override
        public char charAt(int index) {
            return csq.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return csq.subSequence(start, end);
        }

        @Override
        public Appendable append(CharSequence s) throws IOException {
            a.append(s);
            return this;
        }

        @Override
        public Appendable append(CharSequence s, int start, int end) throws IOException {
            a.append(s, start, end);
            return this;
        }

        @Override
        public Appendable append(char c) throws IOException {
            a.append(c);
            return this;
        }
    };
}