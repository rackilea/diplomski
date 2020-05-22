//method declarations need to declare the return type, name, and arguments
int indexOf(String s, char ch) {

 //loop over each index in the string
 for (int i = 0; i < s.length(); i++) {

  //if the char at this index is the one we are looking for
  if (ch == s.charAt(i)) {

   //return the index it was found it
   return i;
  }
 }

 //if we look at each char and do not find the one we want, return -1
 return -1;
}