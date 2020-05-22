public class Solution {
    public String strStr(String haystack, String needle) {
      if(haystack==null || needle==null) return null; 
      int hLength=haystack.length(); 
      int nLength=needle.length(); 
      if(hLength<nLength) return null; 
      if(nLength==0) return haystack;
      for(int i=0; i<=hLength-nLength; i++)
      {
        if(haystack.charAt(i)==needle.charAt(0))
        {
          int j=0; 
          for(; j<nLength; j++)
          {
            if(haystack.charAt(i+j)!=needle.charAt(j))
            {
              break; 
            }
          }
          if(j==nLength) return haystack.substring(i) ; 
        }  
      }
      return null; 
    }
}