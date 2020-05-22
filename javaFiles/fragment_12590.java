int res1 = countString(yourinput , "FLAGE=TRUE");
int res2 = countString(yourinput , "TTT");

int res3 = countTrueTTT(yourinput  , "FLAGE" , "TTT")

public int countString(String yourString , String search){ 
      int sLen = search.length;
  int len = yourString.length;
  int count = 0;
  int index = yourString.indexOf(search, 0);
  while(index > 0){
    count++;
    index = yourString.indexOf(search, index + sLen);
  }

  return count;
}

public int countTrueTTT(String yourString , String under , String search){
   int len = yourString.length;
      int sLen = under.length;
      int count = 0;
      int index = yourString.indexOf(under+"=TRUE" , 0);
      int nextIndex = yourString.indexOf(under , index+sLen);
      while(index > 0 && nextIndex > 0){
        count += countString(yourString.subString(index,nextIndex),search);

        index = yourString.indexOf(under+"=TRUE" , index+sLen);
        nextIndex = yourString.indexOf(under , index+sLen);
        if(nextIndex <0)
          nextIndex = yourString.length;
      }
      return count;
}