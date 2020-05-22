public int strDist(String str, String sub) {
    if (str.length() >= sub.length()) {
        if ((str.substring(0, sub.length())).equals(sub)) {
            if ((str.substring(str.length() - sub.length())).equals(sub)) {
                return str.length();
            } else {
                return strDist(str.substring(0, str.length() - 1), sub);
            }
        } else {
            return (strDist(str.substring(1), sub));
        }
    }
    return 0;
}