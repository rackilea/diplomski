for (int i=startPos;i<str.length();i++) {
   if (str.charAt(i) != str.charAt(i-startPos)) {
      return false;
   }
}
return true;