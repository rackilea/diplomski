public String getBrokenWordsForPdfGeneration(String longString, int cutIndex){
       StringBuffer mainStringBuffer = new StringBuffer(longString);
       String returnString = "";
       while(mainStringBuffer != null && mainString.length()>0 &&                              
mainString.subString(0,mainString.length()>cutIndex?cutIndex:mainString.length()) != null){ 
          if(mainStrig.subString(0,mainString.length()>cutIndex:mainString.length()).trim().contains(" ")){
               returnString += mainStrig.subString(0,mainString.length()>cutIndex:mainString.length()).trim();
               mainStringBuffer.delete(0,mainString.length()>cutIndex:mainString.length());
          }else{
              returnString += mainStrig.subString(0,mainString.length()>cutIndex:mainString.length()).trim()+ " ";
              mainStringBuffer.delete(0,mainString.length()>cutIndex:mainString.length());
          }
    }
    return returnString;
}