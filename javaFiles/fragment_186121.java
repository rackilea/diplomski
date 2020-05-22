String bigInput = "";
      String smallInput = "";

      int s1Len = s1.length();
      int s2Len = s2.length();                
      if(s1Len < s2Len){
           bigInput = s2;
           smallInput = s1;
      }
      else{
           bigInput = s1;
           smallInput = s2;
      }

      char[] bigCharArr = bigInput.toCharArray();
      char[] smallCharArr = smallInput.toCharArray();