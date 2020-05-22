for(int i = 0 ; i < objectArr.length ; i ++){  
   try {
      strArr[i] = objectArr[i].toString();
   } catch (NullPointerException ex) {
       // do some default initialization
   }
}