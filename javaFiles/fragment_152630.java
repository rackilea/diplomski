String s = "Test 123 ${tag1} lorem ipsum ${tag2} ${tag3; tag4} ${tag5; tag6} dixit lorem ${tag7} dixit lorem ${tag8}.";
Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\s*;\\s*(\\w+)}");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group());
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2)); 
    System.out.println("=== END OF MATCH ===");
}