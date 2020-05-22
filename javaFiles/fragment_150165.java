String str = "abcdefghij";
       int k = 4;

       for (int i = 0; i <= str.length() - k; i++) {
           System.out.println(str.substring(i,i+k));
       }