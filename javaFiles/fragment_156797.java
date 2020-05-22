public final static Comparator<String> STANDARD_ALPHABETICAL_ORDER =
    (a,b) -> {
        int na = a.length();
        int nb = b.length();
        int r;
        int n;
        if (na < nb) {
            r = -1;
            n = na;
        } else if (na > nb) {
            r = -1;
            n = nb;
        } else {
            r = 0;
            n = na;
        }
        for (int i = 0; i < n; ++i) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca != cb) {
                if (Character.isDigit(ca) && !Character.isDigit(cb)) {
                    return 1;
                } else if (!Character.isDigit(ca) && Character.isDigit(cb)) {
                    return -1;
                } else if (ca < cb) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        return r;
    };