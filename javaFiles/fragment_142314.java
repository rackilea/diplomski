String s = "4*x+16-455";
Pattern p = Pattern.compile("([0-9]+|[a-z]+|[*//+//-])");
Matcher m = p.matcher(s);
while(m.find()) {
   System.out.println(m.group());
}