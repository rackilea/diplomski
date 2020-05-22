Document doc = con.get();
Elements redirEle = doc.head().select("meta[http-equiv=refresh]");
String content = redirEle.get(0).attr("content");
Pattern pattern = Pattern.compile("^.*URL=(.+)$", Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(content);
if (matcher.matches() && matcher.groupCount() > 0) {
     String redirectUrl = matcher.group(1);
     if(redirectUrl.startsWith("'")){
         /*removes single quotes of urls within single quotes*/
         redirectUrl = redirectUrl.replaceAll("(^')|('$)","");
     }
     if(redirectUrl.startsWith("/")){
         String[] splitedUrl = url.split("/");
         redirectUrl = splitedUrl[0]+"//"+splitedUrl[2]+redirectUrl;
     }
     return redirectUrl;
}