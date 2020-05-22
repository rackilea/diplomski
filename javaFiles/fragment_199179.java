String tmp = "A|B|C|D|E|F|";
String regex = "(\\|).*?(\\|).*?(\\|).*?(\\|).*?(\\|)";
Matcher m = Pattern.compile(regex).matcher(tmp);
if (m.find()) {
    int start  = m.start(1);
    int start1 = m.start(2);
    int start2 = m.start(3);
    int start3 = m.start(4);
    int start4 = m.start(5);
    System.out.println(start + "|" +start1 + "|" +start2 + "|" +start3 + "|" +start4);
}