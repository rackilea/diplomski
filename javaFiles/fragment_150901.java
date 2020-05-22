String in = "Item(s): [item1.test],[item2.qa],[item3.production]";

Pattern p = Pattern.compile("\\[(.*?)\\]");
Matcher m = p.matcher(in);

while(m.find()) {
    System.out.println(m.group(1));
}