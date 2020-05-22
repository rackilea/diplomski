public static String replaceTags(String src, Map<String, String> map) {
    StringBuilder sb = new StringBuilder(src.length() + src.length() / 2);

    for (int pos = 0;;) {
        int ltIdx = src.indexOf('<', pos);
        if (ltIdx < 0) {
            // No more '<', we're done:
            sb.append(src, pos, src.length());
            return sb.toString();
        }

        sb.append(src, pos, ltIdx); // Copy chars before '<'
        // Check if our hit is replaceable:
        boolean mismatch = true;
        for (Entry<String, String> e : map.entrySet()) {
            String key = e.getKey();
            if (src.regionMatches(ltIdx, key, 0, key.length())) {
                // Match, append the replacement:
                sb.append(e.getValue());
                pos = ltIdx + key.length();
                mismatch = false;
                break;
            }
        }
        if (mismatch) {
            sb.append('<');
            pos = ltIdx + 1;
        }
    }
}