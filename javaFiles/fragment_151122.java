public byte[] firstNonNull(byte[]... arrays) {
    for (byte[] array : arrays) {
        if (array != null)
            return array;
    }
    return null;
}