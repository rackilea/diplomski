public int rfind(byte[] data, int pos, int len) {
    for (int i = pos - len; i > -1; i--) {
        if (memcmp(data, i, pos, len)) {
            return i;
        }
    }
    return pos;
}

public boolean memcmp(byte[] data, int idx1, int idx2, int len) {
    for (int i = idx1; i <= len; i++) {
        if (data[i] != data[idx2 + i]) {
            return false;
        }
    }
    return true;
}