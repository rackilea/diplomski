Pattern p = Pattern.compile("MY TEXT (.*) MY TEXT MY TEXT (.*) My TEXT");
Matcher m = p.matcher("MY TEXT hello you MY TEXT MY TEXT are here My TEXT");
if (m.find()) {
     System.out.println(m.group(1));  // prints 'hello you'
     System.out.println(m.group(2));  // prints 'are here'
}