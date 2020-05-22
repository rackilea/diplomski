private static CharSequence mapAsciiBasedText(Path p, char[] table) throws IOException {
    try(FileChannel fch = FileChannel.open(p, StandardOpenOption.READ)) {
        long actualSize = fch.size();
        int size = (int)actualSize;
        if(size != actualSize) throw new UnsupportedOperationException("file too large");
        MappedByteBuffer mbb = fch.map(FileChannel.MapMode.READ_ONLY, 0, actualSize);
        final class MappedCharSequence implements CharSequence {
            final int start, size;
            MappedCharSequence(int start, int size) {
                this.start = start;
                this.size = size;
            }
            public int length() {
                return size;
            }
            public char charAt(int index) {
                if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
                byte b = mbb.get(start + index);
                return b<0? table[b+256]: (char)b;
            }
            public CharSequence subSequence(int start, int end) {
                int newSize = end - start;
                if(start<0 || end < start || end-start > size)
                    throw new IndexOutOfBoundsException();
                return new MappedCharSequence(start + this.start, newSize);
            }
            public String toString() {
                return new StringBuilder(size).append(this).toString();
            }
        }
        return new MappedCharSequence(0, size);
    }
}