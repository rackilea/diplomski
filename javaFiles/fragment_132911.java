String data1="SELECT name, age FROM table1 whatever";
String data2="SELECT name, age FROM schema.table1 whatever";

Pattern p=Pattern.compile("from\\s+(?:\\w+\\.)*(\\w+)($|\\s+[WHERE,JOIN,START\\s+WITH,ORDER\\s+BY,GROUP\\s+BY])",Pattern.CASE_INSENSITIVE);

//test
Matcher m=p.matcher(data1);
while(m.find())
    System.out.println(m.group(1));
m=p.matcher(data2);
while(m.find())
    System.out.println(m.group(1));