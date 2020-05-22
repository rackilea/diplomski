for (int i = 0; i< temp.length; i++) {  
  if (temp [i] == 2 ){
    boolean foundAnother = false;
    for (int j = 0; j< temp.length; j++) { 
      if (i != j && temp [j] == 2 ){
        foundAnother = true;  
      }  
    }
    if (!foundAnother) {
      return true;
    }
  }  
}
return false;