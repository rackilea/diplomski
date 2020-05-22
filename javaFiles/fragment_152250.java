public class BookmarkEngine implements IBookmarkEngine {

     private static final String URL_PREFIX = "http://";

     @Override
     public String getFullUrl(String url) {

         if (!url.startsWith(URL_PREFIX)) {
             return  URL_PREFIX + url;
         }
         return url;
     }
 }