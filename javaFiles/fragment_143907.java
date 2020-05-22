private boolean isValidUrl(String url) {
      Pattern p = Patterns.WEB_URL;
      Matcher m = p.matcher(url.toLowerCase());
      if(m.matches())
         return true;
      else
        return false;
}