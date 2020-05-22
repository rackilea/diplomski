static void join(StringBuilder sb, String str) {
    if (!str.isEmpty()) {
        if (sb.length() > 0) {
            sb.append('~');
        }
        sb.append(str);
    }
}