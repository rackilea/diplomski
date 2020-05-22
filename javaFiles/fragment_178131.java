String s = "{Abc}{Defg}100{Hij}100{/Klmopr}{/Stuvw}"; // just a sample String
Pattern p = Pattern.compile("\\{\\W*(\\w++)\\W*\\}");
Matcher m = p.matcher(s);
while(m.find()) {
    System.out.println(m.group(1) + ", length: " + m.group(1).length());
}