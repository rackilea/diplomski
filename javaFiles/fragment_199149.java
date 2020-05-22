String regex = "10.\\d{4,9}/[-._;()/:A-Z0-9]+" +
              "|10.1002/[^\\s]+" +
              "|10.\\d{4}/\\d+-\\d+X?(\\d+)\\d+<[\\d\\w]+:[\\d\\w]*>\\d+.\\d+.\\w+;\\d" +
              "|10.1021/\\w\\w\\d++" +
              "|10.1207/[\\w\\d]+\\&\\d+_\\d+";
Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

String input = "http://journals.ametsoc.org/doi/full/10.1175/JPO3002.1";
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println("Start index: " + m.start() +
                       " End index: " + m.end() +
                       " " + m.group());
}