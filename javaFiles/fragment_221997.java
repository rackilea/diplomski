public int getElementThatContains(String[] ips, String key) {
    for (int i = 0; i < ips.length; i++) {
        if (ips[i].indexOf(key) >= 0) {
            return i;
        }
    }
    return -1;
}