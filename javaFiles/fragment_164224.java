final Iterator<byte[]> iter = bytearrays.iterator();
while (iter.hasNext()) {
    final byte[] temp = iter.next();
    // TODO check for zero-length arrays
    if (temp[0] == -7) {
        iter.remove();
    }
}