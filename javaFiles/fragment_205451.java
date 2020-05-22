public static boolean isNetworkUrl(String url) {
       if (url == null || url.length() == 0) {
            return false;
        }
        return isHttpUrl(url) || isHttpsUrl(url);
   }