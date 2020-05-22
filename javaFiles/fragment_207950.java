for(int i = 0; i < str.length(); i++) {
     char c = str.charAt(i);
     if(c >= '0' && c <= '9') {
         return i;
     }
 }
 return -1;