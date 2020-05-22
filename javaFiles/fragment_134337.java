public int compare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char u1 = Character.toUpperCase(c1);
            char u2 = Character.toUpperCase(c2);
            char l1 = Character.toLowerCase(c1);
            char l2 = Character.toLowerCase(c2);

            if (u1 != u2) {
                return u1 - u2;
            } else {
                if (l1 != l2) {
                    return l1 - l2;
                } else if (c1 != c2) {
                    return c1 - c2;
                }
            }
        }
        return n1 - n2;
    }