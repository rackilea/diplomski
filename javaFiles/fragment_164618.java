String[] vars = {"", ""};

String toCheck = "var1=val1&&var2=val2";

Pattern p = Pattern.compile(".*?=(.*?).*?=(.*$)");
Matcher m = p.matcher(toCheck);

while(m.find()){
    vars[0] = m.group(1);
    vars[1] = m.group(2);
}