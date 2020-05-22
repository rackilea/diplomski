Pattern pattern = Pattern.compile("^([\\w]+)(?=\\s)|(?<=\\*)(.+?)(?=\\)|$)");
Matcher matcher = pattern.matcher(word);
while (matcher.find()) {
     String sub1 = matcher.group(1);
     String sub2 = matcher.group(2);
     if(sub1 != null) System.out.println(sub1);
     else if(sub2 != null) System.out.println(sub2); 
}