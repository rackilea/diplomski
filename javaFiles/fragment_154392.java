/**
 * Pads data with zero valued bytes until the next block boundary is met.
 * Does not pad if the number of blocks is already on a boundary. This
 * method is not safe for binary data that may end with zero valued bytes as
 * they may be removed by the unpadding method.
 * If available, try and use PKCS#7 compatible padding instead.
 * 
 * @param data
 *            the binary data to pad, never null
 * @param blocksize
 *            the block size in bytes of the block cipher
 * @return the padded binary data as a copy
 * @throws NullPointerException
 *             if data is null
 */
public static byte[] phpPad(final byte[] data, final int blocksize) {
    if (data.length == 0) {
        return data;
    }

    final int blocks = (data.length - 1) / blocksize + 1;
    return Arrays.copyOf(data, blocks * blocksize);
}

/**
 * Unpads data removing zero valued bytes, removing up to blocksize - 1
 * bytes of padding. The input of the unpad method should consist of n times
 * the blocksize.
 * 
 * @param data
 *            the binary data to unpad, never null
 * @param blocksize
 *            the block size in bytes of the block cipher
 * @return the unpadded binary data as a copy
 * @throws NullPointerException
 *             if data is null
 * @throws IllegalArgumentException
 *             if the data is not n times the blocksize
 */
public static byte[] phpUnpad(final byte[] data, final int blocksize) {
    if (data.length % blocksize != 0) {
        throw new IllegalArgumentException(
                "Padded data should dividable by the block size");
    }

    if (data.length == 0) {
        return data.clone();
    }

    int padBytes = 0;
    for (; padBytes < blocksize; padBytes++) {
        if (data[data.length - padBytes - 1] != 0x00) {
            break;
        }
    }

    return Arrays.copyOf(data, data.length - padBytes);
}