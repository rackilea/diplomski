String text = "$abc$and$xyz$";
    Scanner sc = new Scanner(text);

    while (sc.findInLine("\\$([^$]*)\\$") != null) {
        System.out.println(sc.match().group(1));
    } // abc, xyz