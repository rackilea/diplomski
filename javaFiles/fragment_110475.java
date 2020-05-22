String c = "(90,100)";
    int[] x = new int[2];
    Pattern p = Pattern.compile("([(\\[])(\\d+),(\\d+)([)\\]])");
    Matcher m = p.matcher(c);
    if (!m.matches()) {
        // input is invalid
        System.out.println("Bad input string: " + c);
    } else {
        // input is valid
        char start = m.group(1).charAt(0);
        char stop = m.group(4).charAt(0);
        x[0] = Integer.parseInt(m.group(2));
        x[1] = Integer.parseInt(m.group(3));
        for (int y : x) {
            System.out.println(y);
        }
    }