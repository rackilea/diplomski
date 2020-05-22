String sequence="abcdefg";
      String[] words=new String[sequence.length()-2];
      int i;

      for(i=0;i<=(sequence.length()-3);i++){        
         words[i]=sequence.substring(i,3+i);
         System.out.println(words[i]);
    }