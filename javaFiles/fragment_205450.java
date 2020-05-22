public static boolean isValidUrl(String url) {
      if (url == null || url.length() == 0) {
          return false;
      }

      return (isAssetUrl(url) ||
             isResourceUrl(url) ||
               isFileUrl(url) ||
               isAboutUrl(url) ||
             isHttpUrl(url) ||
             isHttpsUrl(url) ||
             isJavaScriptUrl(url) ||
            isContentUrl(url));
   }