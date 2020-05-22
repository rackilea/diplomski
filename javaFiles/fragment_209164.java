for (int i = 0; i < subArray.length; i++) {
        if(i==subArray.length-1){
            patternbuilder.append("( ?"+subArray[i]+")?");
        }else{
            patternbuilder.append("( ?"+subArray[i]+")?");
      }
   }