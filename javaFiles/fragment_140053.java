SimpleDateFormat parser = new SimpleDateFormat("Z s#S");

    System.out.println(parser.parse("GMT 1#002").getTime());  // 1002
    System.out.println(parser.parse("GMT 1#02").getTime());   // 1002
    System.out.println(parser.parse("GMT 1#2").getTime());    // 1002
    System.out.println(parser.parse("GMT 1#20").getTime());   // 1020
    System.out.println(parser.parse("GMT 1#200").getTime());  // 1200