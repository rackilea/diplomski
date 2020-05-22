String sPattern = "max=([0-9]+), total=([0-9]+), free=([0-9]+)";
    Pattern pattern = Pattern.compile( sPattern, Pattern.CASE_INSENSITIVE );

    String source = "control.avgo: max=259522560, total=39325696, free=17979640";
    Matcher matcher = pattern.matcher( source );
    if ( matcher.find()) {
        System.out.println("max=" + matcher.group(1));
        System.out.println("total=" + matcher.group(2));
        System.out.println("free=" + matcher.group(3));
    }