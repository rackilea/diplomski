public static String filterDecode(String url){

   url = url.replaceAll("&amp;", "&")
     .replaceAll("&lt;", "<")
     .replaceAll("&gt;", ">")
     .replaceAll("&apos;", "\'")
     .replaceAll("&quot;", "\"")
     .replaceAll("&nbsp;", " ")
     .replaceAll("&copy;", "@")
     .replaceAll("&reg;", "?");
   return url;
 }