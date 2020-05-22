String pattern = "(\\w+)\\.(.*)=\\[(.*)\\]";

    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line);

    if (m.find()) {
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        System.out.println(m.group(3));
    }