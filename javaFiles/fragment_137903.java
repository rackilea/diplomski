public static float[] unpack(
    byte[] bytes,
    long[] transfer,
    float[] samples,
    int bvalid,
    AudioFormat fmt
) {
    if(fmt.getEncoding() != AudioFormat.Encoding.PCM_SIGNED
            && fmt.getEncoding() != AudioFormat.Encoding.PCM_UNSIGNED) {

        return samples;
    }

    final int bitsPerSample = fmt.getSampleSizeInBits();
    final int bytesPerSample = bitsPerSample / 8;
    final int normalBytes = normalBytesFromBits(bitsPerSample);

    /*
     * not the most DRY way to do this but it's a bit more efficient.
     * otherwise there would either have to be 4 separate methods for
     * each combination of endianness/signedness or do it all in one
     * loop and check the format for each sample.
     * 
     * a helper array (transfer) allows the logic to be split up
     * but without being too repetetive.
     * 
     * here there are two loops converting bytes to raw long samples.
     * integral primitives in Java get sign extended when they are
     * promoted to a larger type so the & 0xffL mask keeps them intact.
     * 
     */

    if(fmt.isBigEndian()) {
        for(int i = 0, k = 0, b; i < bvalid; i += normalBytes, k++) {
            transfer[k] = 0L;

            int least = i + normalBytes - 1;
            for(b = 0; b < normalBytes; b++) {
                transfer[k] |= (bytes[least - b] & 0xffL) << (8 * b);
            }
        }
    } else {
        for(int i = 0, k = 0, b; i < bvalid; i += normalBytes, k++) {
            transfer[k] = 0L;

            for(b = 0; b < normalBytes; b++) {
                transfer[k] |= (bytes[i + b] & 0xffL) << (8 * b);
            }
        }
    }

    final long fullScale = (long)Math.pow(2.0, bitsPerSample - 1);

    /*
     * the OR is not quite enough to convert,
     * the signage needs to be corrected.
     * 
     */

    if(fmt.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {

        /*
         * if the samples were signed, they must be
         * extended to the 64-bit long.
         * 
         * so first check if the sign bit was set
         * and if so, extend it.
         * 
         * as an example, imagining these were 4-bit samples originally
         * and the destination is 8-bit, a mask can be constructed
         * with -1 (all bits 1) and a left shift:
         * 
         *     11111111
         *  <<  (4 - 1)
         *  ===========
         *     11111000
         * 
         * (except the destination is 64-bit and the original
         * bit depth from the file could be anything.)
         * 
         * then supposing we have a hypothetical sample -5
         * that ought to be negative, an AND can be used to check it:
         * 
         *    00001011
         *  & 11111000
         *  ==========
         *    00001000
         * 
         * and an OR can be used to extend it:
         * 
         *    00001011
         *  | 11111000
         *  ==========
         *    11111011
         * 
         */

        final long signMask = -1L << bitsPerSample - 1L;

        for(int i = 0; i < transfer.length; i++) {
            if((transfer[i] & signMask) != 0L) {
                transfer[i] |= signMask;
            }
        }
    } else {

        /*
         * unsigned samples are easier since they
         * will be read correctly in to the long.
         * 
         * so just sign them:
         * subtract 2^(bits - 1) so the center is 0.
         * 
         */

        for(int i = 0; i < transfer.length; i++) {
            transfer[i] -= fullScale;
        }
    }

    /* finally normalize to range of -1.0f to 1.0f */

    for(int i = 0; i < transfer.length; i++) {
        samples[i] = (float)transfer[i] / (float)fullScale;
    }

    return samples;
}

public static int normalBytesFromBits(int bitsPerSample) {

    /*
     * some formats allow for bit depths in non-multiples of 8.
     * they will, however, typically pad so the samples are stored
     * that way. AIFF is one of these formats.
     * 
     * so the expression:
     * 
     *  bitsPerSample + 7 >> 3
     * 
     * computes a division of 8 rounding up (for positive numbers).
     * 
     * this is basically equivalent to:
     * 
     *  (int)Math.ceil(bitsPerSample / 8.0)
     * 
     */

    return bitsPerSample + 7 >> 3;
}