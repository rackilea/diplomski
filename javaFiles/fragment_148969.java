String result  = "<input type=\"hidden\" name=\"token\" value=\"YToxOntzOjU\"/>";

Pattern pattern = Pattern.compile("name=\"(token)\"[^>]*value=\"([^\"]+)\"", 2);
Matcher matcher = pattern.matcher(result); 

if (matcher.find()) {
   String value = matcher.group(2);
   System.out.println(value); //=> "YToxOntzOjU"
}