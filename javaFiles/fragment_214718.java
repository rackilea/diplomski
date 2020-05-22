String str = "Test123 is12 good123";
int total = 0;
String[] m = str.split("[^\\d]+");
for (String s : m) {
    if (!s.equals("")) {
        total += Integer.parseInt(s);
    }
}
System.out.println("Total of above string is:" + total);