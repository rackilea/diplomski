String text = "EQ=ENABLED,QLPUB=502,EPRE=ENABLED";      
String pattern = "^EQ=ENABLED,QLPUB=\\d*,EPRE=ENABLED$";

Pattern compiledPattern = Pattern.compile(pattern);
Matcher matcher = compiledPattern.matcher(text);
if(matcher.find()) {
    System.out.println(matcher.group());
}