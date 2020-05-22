String name = "foo-bar_2014-10-14_18.56.05_bar";
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss", Locale.ENGLISH);
    String pattern = "\\d{4}-\\d{2}-\\d{2}_\\d{2}\\.\\d{2}\\.\\d{2}";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    if (m.find()) {
        System.out.println("Found value: " + m.group(0));
        Date result = df.parse(m.group(0));
        System.out.println("result: " + result);
    } else {
        System.out.println("NO MATCH");
    }