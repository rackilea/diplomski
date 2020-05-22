for(int j = scores.length-1; j >= 0; j--){
      if(j > 0) {
          boolean b = scores[j] <= scores[j-1] ? true : false;
          if(b == false){
           c++;
          }
       }
   }