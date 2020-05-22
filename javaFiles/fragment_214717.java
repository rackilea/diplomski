String str = "Test123 is12 good123";
int total = 0;
Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher(str);
while (m.find()) {
    total += Integer.parseInt(m.group());
}
System.out.println("Total of above string is: " + total);//Total of above string is: 258