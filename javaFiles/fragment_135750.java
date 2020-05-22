for (Element e : body.select("iframe")) {

  //This gets individual elements, rather than the first one of each post.
  array[k] = e.attr("src");

  String pattern = "(?<=watch\\?v=|/embed/)[^&#]*";
Pattern compiledPattern = Pattern.compile(pattern);
Matcher matcher = compiledPattern.matcher(array[k]);
while(matcher.find()){
    array1[k] = matcher.group();



    e.html("<img src=\"http://img.youtube.com/vi/"+array1[k]+"/0.jpg\"/></br>Tap to play video");
    //System.out.println(iframes);
}