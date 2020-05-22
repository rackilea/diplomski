public static boolean textValidator(String text){
    Pattern pattern = Pattern.compile("\\S+");
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()){
      return true; 
    } 
    return false; 
    }