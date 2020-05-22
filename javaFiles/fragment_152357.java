static class StringCache {
    final WeakReference<String>[] strings;
    final int mask;

    @SuppressWarnings("unchecked")
    StringCache(int size) {
        int size2 = 128;
        while (size2 < size)
            size2 *= 2;
        strings = new WeakReference[size2];
        mask = size2 - 1;
    }

    public String intern(String text) {
        if (text.length() == 0) return "";

        int hash = text.hashCode() & mask;
        WeakReference<String> wrs = strings[hash];
        if (wrs != null) {
            String ret = wrs.get();
            if (text.equals(ret))
                return ret;
        }
        String ret = new String(text);
        strings[hash] = new WeakReference<String>(ret);
        return ret;
    }
}