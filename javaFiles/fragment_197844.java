String s = ":20:AND:HERE";
Pattern pattern = Pattern.compile("^:([^:]*):(.*)$");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println("Key: " + matcher.group(1) + ", Value: " + matcher.group(2) + "\n"); 
}