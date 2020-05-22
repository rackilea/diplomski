String def = "\\((\\-?\\d+\\.\\d+),\\s*(\\-?\\d+\\.\\d+)\\)";
    String text = "hello (30.6284, -27.3493)  (30.6284, -27.3493) ";
    Pattern p = Pattern.compile(def);
    Matcher m = p.matcher(text);
    while (m.find()) {
        System.out.println(text.substring(m.start(), m.end()));
    }