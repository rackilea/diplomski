byte[] encode(char[] ca, int off, int len) {
        int en = scale(len, ce.maxBytesPerChar());
        byte[] ba = new byte[en];
        if (len == 0)
            return ba;
        if (ce instanceof ArrayEncoder) {
            int blen = ((ArrayEncoder)ce).encode(ca, off, len, ba);
            return safeTrim(ba, blen, cs, isTrusted);
        } else {
            ce.reset();
            ByteBuffer bb = ByteBuffer.wrap(ba);
            CharBuffer cb = CharBuffer.wrap(ca, off, len);
            try {
                CoderResult cr = ce.encode(cb, bb, true);
                if (!cr.isUnderflow())
                    cr.throwException();
                cr = ce.flush(bb);
                if (!cr.isUnderflow())
                    cr.throwException();
            } catch (CharacterCodingException x) {
                // Substitution is always enabled,
                // so this shouldn't happen
                throw new Error(x);
            }
            return safeTrim(ba, bb.position(), cs, isTrusted);
        }
    }
}

private static int scale(int len, float expansionFactor) {
    // We need to perform double, not float, arithmetic; otherwise
    // we lose low order bits when len is larger than 2**24.
    return (int)(len * (double)expansionFactor);
}

private static char[] safeTrim(char[] ca, int len,
                               Charset cs, boolean isTrusted) {
    if (len == ca.length && (isTrusted || System.getSecurityManager() == null))
        return ca;
    else
        return Arrays.copyOf(ca, len);
}