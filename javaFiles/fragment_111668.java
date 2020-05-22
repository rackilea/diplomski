@Override
    public int getArgbPre(ByteBuffer buffer, int offset) {
        return (((buffer.get(offset    ) & 0xff)      ) |
                ((buffer.get(offset + 1) & 0xff) <<  8) |
                ((buffer.get(offset + 2) & 0xff) << 16) |
                ((buffer.get(offset + 3)       ) << 24));
    }