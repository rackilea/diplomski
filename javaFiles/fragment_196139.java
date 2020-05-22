String s = "ABCDE";
    final int L = s.length();
    for (int i = 0; i < L; i++) {
        System.out.format("%c%c%c ",
            s.charAt(i),
            s.charAt((i + 1) % L),
            s.charAt((i + 2) % L)
        );
    } // prints "ABC BCD CDE DEA EAB "