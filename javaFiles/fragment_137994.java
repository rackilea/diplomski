public String convertStringToHex(String str){

  char[] chars = str.toCharArray();

  StringBuffer hex = new StringBuffer();
  for(int i = 0; i < chars.length; i++){
    hex.append(String.format("%02x", ((int)chars[i])));
  }

  return hex.toString();