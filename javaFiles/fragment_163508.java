class CharBufferDocument implements Document {
    private final CharBuffer charBuffer;
    private final int length;
    private final int[] lineOffsets;

    public CharBufferDocument(CharBuffer charBuffer) {
        this.charBuffer = charBuffer;

        charBuffer.position(0);
        length = charBuffer.length();

        int[] lineOffsets = new int[] { 0 };
        int lineCount = 1;

        for (int i = 0; i < length; i++) {
            char c = charBuffer.get(i);
            if (c == '\n') {
                if (lineCount == lineOffsets.length) {
                    if (lineCount == Integer.MAX_VALUE) throw new OutOfMemoryError();
                    int newLength = (int)Math.min(lineCount * 2L, Integer.MAX_VALUE);
                    lineOffsets = Arrays.copyOf(lineOffsets, newLength);
                }
                lineOffsets[lineCount++] = i + 1;
            }
        }

        lineOffsets = Arrays.copyOf(lineOffsets, lineCount);
        this.lineOffsets = lineOffsets;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void addDocumentListener(DocumentListener listener) {}

    @Override
    public void removeDocumentListener(DocumentListener listener) {}

    @Override
    public void addUndoableEditListener(UndoableEditListener listener) {}

    @Override
    public void removeUndoableEditListener(UndoableEditListener listener) {}

    @Override
    public void putProperty(Object key, Object value) {}

    @Override
    public Object getProperty(Object key) {
        return null;
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        throw new UnsupportedOperationException("Document is immutable");
    }

    @Override
    public void insertString(int offset, String str, AttributeSet a)
            throws BadLocationException {
        throw new UnsupportedOperationException("Document is immutable");
    }

    @Override
    public String getText(int offset, int length) throws BadLocationException {
        char[] out = new char[length];
        charBuffer.position(offset);
        charBuffer.get(out);
        return new String(out);
    }

    @Override
    public void getText(int offset, int length, Segment segment) throws BadLocationException {
        segment.array = new char[length];
        charBuffer.position(offset);
        charBuffer.get(segment.array);
        segment.offset = 0;
        segment.count = length;
    }

    @Override
    public Position getStartPosition() {
        return createPosition(0);
    }

    @Override
    public Position getEndPosition() {
        return createPosition(getLength());
    }

    @Override
    public Position createPosition(int offset) {
        return new ImmutablePosition(offset);
    }

    private final Element rootElement = new Element() {
        @Override
        public Document getDocument() {
            return CharBufferDocument.this;
        }

        @Override
        public Element getParentElement() {
            return null;
        }

        @Override
        public String getName() {
            return "root";
        }

        @Override
        public AttributeSet getAttributes() {
            return null;
        }

        @Override
        public int getStartOffset() {
            return 0;
        }

        @Override
        public int getEndOffset() {
            return getLength();
        }

        @Override
        public int getElementIndex(int offset) {
            // binary search for the line that contains offset
            int low = 0;
            int high = lineOffsets.length - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midLineStart = lineOffsets[mid];
                int midLineEnd = (mid + 1 < lineOffsets.length) ? (lineOffsets[mid + 1] - 1) : getLength();

                if (offset < midLineStart) {
                    high = mid - 1;
                } else if (offset > midLineEnd) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return 0;
        }

        @Override
        public int getElementCount() {
            return lineOffsets.length;
        }

        @Override
        public Element getElement(int index) {
            return createLineElement(
                lineOffsets[index],
                (index + 1 < lineOffsets.length) ? (lineOffsets[index + 1] - 1) : getLength()
            );
        }

        @Override
        public boolean isLeaf() {
            return false;
        }
    };

    private Element createLineElement(final int start, final int end) {
        return new Element() {
            @Override
            public Document getDocument() {
                return CharBufferDocument.this;
            }

            @Override
            public Element getParentElement() {
                return CharBufferDocument.this.getDefaultRootElement();
            }

            @Override
            public String getName() {
                return "line"; // XXX: Does the name matter?
            }

            @Override
            public AttributeSet getAttributes() {
                return null;
            }

            @Override
            public int getStartOffset() {
                return start;
            }

            @Override
            public int getEndOffset() {
                return end;
            }

            @Override
            public int getElementIndex(int offset) {
                return -1;
            }

            @Override
            public int getElementCount() {
                return 0;
            }

            @Override
            public Element getElement(int index) {
                return null;
            }

            @Override
            public boolean isLeaf() {
                return true;
            }
        };
    }

    @Override
    public Element getDefaultRootElement() {
        return rootElement;
    }

    @Override
    public Element[] getRootElements() {
        return new Element[] { getDefaultRootElement() };
    }

    @Override
    public void render(Runnable r) {
        r.run();
    }

    private static class ImmutablePosition implements Position {
        private final int offset;

        private ImmutablePosition(int offset) {
            this.offset = offset;
        }

        @Override
        public int getOffset() {
            return offset;
        }
    }
}