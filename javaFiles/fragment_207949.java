Pattern pattern = Pattern.compile("\\d");
 Matcher matcher = pattern.matcher(inputString);
 if(matcher.find()) {
     return matcher.first();
 }
 return -1;