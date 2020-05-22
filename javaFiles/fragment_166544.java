private static URL safeURL(String urlText) {
     try {
         return new URL(urlText);
     } catch (MalformedURLException e) {
         // Ok, so this should not have happened
         throw new IllegalArgumentException("Invalid URL " + urlText, e);  
     }
 }