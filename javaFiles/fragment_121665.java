public static int contains(String s1, String s2) {
    int i = s2.length()-1, j = s1.length()-1;

    if(i > j)
        return -1;

    for(; i > -1; i--) {
        for(; j >= 0; j--) {
            if(s1.charAt(j) == s2.charAt(i)) {
                if(i == 0)
                    return j;

                if(j != 0)
                    j--;

                break;
            } else if(i != s2.length()) {
                i = s2.length()-1;
            }
        }
    }

    return -1;
}