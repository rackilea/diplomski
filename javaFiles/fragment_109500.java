String str = "12 3 1 265";
    String[] strArray = str.split(" ");

    for(String s : strArray){
      char[] charArray = s.toCharArray();
      for(char c : charArray){
         // your logic to parse and store
          System.out.println(c);
      }
 }