public static void insertString(CompositeByteBuf buffer, int index, ByteBuf insertion) {
    try {
        if (buffer == null) {
            throw new NullPointerException("buffer");
        }
        if (insertion == null) {
            throw new NullPointerException("insertion");
        }
        if (buffer.readableBytes() < index) {
            throw new IllegalArgumentException("buffer.readableBytes() < index: "
                    + buffer.readableBytes() + " < " + index);
        }

        // Start by checking the offset where we need to inject the insertion
        int injectionBufOffset;
        int injectionByteOffset;
        if (index == buffer.readableBytes()) {
            injectionBufOffset = buffer.numComponents();
            injectionByteOffset = 0;
        } else {
            injectionBufOffset = buffer.toComponentIndex(index);
            injectionByteOffset = index - buffer.toByteIndex(injectionBufOffset);
        }

        // Optimalize in the case of offset 0
        if (injectionByteOffset == 0) {
            buffer.addComponent(injectionBufOffset, insertion.retain());
            buffer.writerIndex(buffer.writerIndex() + insertion.readableBytes());
            return;
        }
        // Do the split technique
        ByteBuf toSplit = buffer.internalComponent(injectionBufOffset).retain();
        try {
            buffer.removeComponent(injectionBufOffset);
            buffer.addComponent(injectionBufOffset + 0,
                    toSplit.readSlice(injectionByteOffset).retain());
            buffer.addComponent(injectionBufOffset + 1, insertion.retain());
            buffer.addComponent(injectionBufOffset + 2,
                    toSplit.retain());
            buffer.writerIndex(buffer.writerIndex() + insertion.readableBytes());
        } finally {
            ReferenceCountUtil.release(toSplit);
        }
    } finally {
        if (insertion != null) {
            ReferenceCountUtil.release(insertion);
        }
    }
}