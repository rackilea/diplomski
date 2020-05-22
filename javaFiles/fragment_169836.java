String str = "/hello.there#test";
Pattern ptrn = Pattern.compile("/([^#?]*)");
Matcher matcher = ptrn.matcher(str);
if (matcher.find()) {
    System.out.println(matcher.group());  // => /hello.there
    System.out.println(matcher.group(1)); // => hello.there
}