String s = " something.js > /some/path/to/x19-v1.0.js < y < z < a > b > c > d";
    String regex = "(?=[\\s,;]+|(?<![\\w\\/\\-\\.])([\\w\\/\\-\\.]+\\s*[<>]\\s*[\\w\\/\\-\\.]+))";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(s);
    while (m.find()) {
        String d = m.group(1);
        if(d != null) {
            System.out.println(d);
        }
    }