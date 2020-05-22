public static String reverse (String str){  
      //New code
      if (str == null) {
           str = "null";
      }

      String reverse = "";
      for(int i = str.length() - 1; i >= 0; i--){
          reverse += str.charAt(i);
      }
      return reverse;
 }