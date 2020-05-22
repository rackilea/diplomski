// solution with regex
Pattern fileName = Pattern.compile(".+(?<!/)/(?!/)(.+?)\\..+?");
Matcher matcher = fileName.matcher(url);
if (matcher.find()) {
    System.out.println(matcher.group(1));
    String replacedURLWithRegex = url.replace(matcher.group(1), "blah");
    System.out.println(replacedURLWithRegex);
}