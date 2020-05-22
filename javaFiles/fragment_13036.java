try {
   //.Convert string to Integer 
   if (Integer.valueOf(number) > 0) {
      //. Do that
   } else {
     //. Otherwise
   }
} catch (NumberFormatException err) {
  err.printStackTrace();
  //.Conversion failed. The user entered a non numeric string
}