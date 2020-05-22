String a = "    example   ";
    System.out.println(a);
    a.trim();      // String trimmed.
    System.out.println(a);// still old string as it is declared.
    a = "    example   ";
    a = a.trim();  //got the returned string, now a is new String returned ny trim()
    System.out.println(a);// new string