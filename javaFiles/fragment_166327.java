byte[] array = bigInteger.toByteArray();
if (array[0] == 0) {
    byte[] tmp = new byte[array.length - 1];
    System.arraycopy(array, 1, tmp, 0, tmp.length);
    array = tmp;
}