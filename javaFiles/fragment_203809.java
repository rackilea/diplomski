String pat1 = ".*\uD840\uDC00{2}.*";
    String s1  = "HI \uD840\uDC00\uD840\uDC00 BYE";
    System.out.println(s1.matches(pat1) + " len=" + s1.length());

    String pat2 = ".*\u0040\u0041{2}.*";
    String s2 = "HI \u0040\u0041\u0040\u0041 BYE";
    System.out.println(s2.matches(pat2) + " len=" + s2.length());