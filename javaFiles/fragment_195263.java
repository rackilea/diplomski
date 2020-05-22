String pattern = "(.+)(Tutorial\\s\\d+)";
    Pattern r = Pattern.compile(pattern);
    String[] s = { "sonop@us.ac.zaTutorial 1",
            "randomperson@gmail.comTutorial 3" };
    for (String str : s) {
        Matcher m = r.matcher(str);
        if (m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }