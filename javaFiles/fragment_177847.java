String s = "0:ID IN (1002,25);1:ID IN (2,3,4) AND COQ>=0 AND COQ<=9;2:ID IN (73150,73150) AND TOTAL>=0 AND TOTAL<=99999";
Pattern pattern = Pattern.compile("(?:^\\s*(?!\\s*\\d+\\s*:)|\\d+\\s*:)((?:\'[^\']*\'|\"[^\"]*\"|[^;])+)");
Matcher matcher = pattern.matcher(s);
System.out.println("Match 1:\n");
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}