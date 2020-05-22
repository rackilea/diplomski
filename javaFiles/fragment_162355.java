final Pattern pattern = Pattern
            .compile("Mfr Part#: ([^ ]+) (Technologie|Mounting).*");
    final Matcher matcher = pattern
            .matcher("Mfr Part#: MBRB1045G Mounting");
    matcher.matches();
    System.out.println(matcher.group(1));