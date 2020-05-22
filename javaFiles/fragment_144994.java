public boolean isValid(String value)
  {

      String jpgChk = "\\.jpg$";
      String pngChk = "\\.png$";
      Matcher jpgMatcher = Pattern.compile(jpgChk).matcher(value);
      Matcher pngMatcher = Pattern.compile(pngChk).matcher(value);
      if(jpgMatcher.find())
          return value.contains(".png")?false:true;
      else if (pngMatcher.find())
          return value.contains(".jpg")?false:true;
      else
          return false;
  }