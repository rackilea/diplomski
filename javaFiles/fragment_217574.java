Pattern pattern = Pattern.compile("v=([^&]+)");
String url = "http://www.youtube.com/watch?v=-mzvAAuCo1c&foo=3";
Matcher matcher = pattern.matcher(url);
if (matcher.find()) {
    System.out.println(matcher.groupCount()); 
    System.out.println(matcher.group(1)); 
}