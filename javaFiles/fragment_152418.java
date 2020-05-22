String str= "Hello this is paragraph , Ali@yahoo.com . i am " +
            "entering  random  email here as this one  AHmar@gmail.com " ;

Pattern pattern = Pattern.compile("@(\\S+)\\.\\w+");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
     System.out.println(matcher.group(1));
}