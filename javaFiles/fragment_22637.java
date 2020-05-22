String phrase = "Heres is one line\r\n" +
                "and another\r" +
                "and another one\n" +
                "all with different line ending chars";

Pattern p = Pattern.compile("\\V+|\\v+");
Matcher m=p.matcher(phrase);
while(m.find()) {
            System.out.println(m.group(0).replace("\n", "\\n").replace("\r", "\\r"));
} // .replace("\n", "\\n").replace("\r", "\\r") is only for demo