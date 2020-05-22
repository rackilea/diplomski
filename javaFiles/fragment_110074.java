public byte[] toByteArray(int[] values) {
    byte[] ret = new byte[values.length];
    for (int i = 0; i < values.length; i++) {
        ret[i] = (byte) (values[i] - 128);
    }
    return ret;
}

public int[] toIntArray(int[] values) {
    int[] ret = new byte[values.length];
    for (int i = 0; i < values.length; i++) {
        ret[i] = values[i] + 128;
    }
    return ret;
}