String regex = "\\B\\$\\w+\\$\\B";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("$abc$ cde$efg$hij pqr");
while (matcher.find()){
    System.out.println(matcher.group(0)); 
} // => $abc$