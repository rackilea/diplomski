import java.util.*;
import java.lang.*;

public class Solution {

  public List<List<String>> partition(String s) {

      List<List<String>> result = new ArrayList<>();
      backTrack(result, new ArrayList<String>(), new StringBuilder(s).reverse().toString());  // EDIT 1: Invert String

      return result;
  }

  private void backTrack(List<List<String>> result, List<String> cur, String s) {
      if(s.length() == 0) result.add(new ArrayList<>(cur));

      for(int i = 0; i < s.length(); i++){
          if(isPalindrome(s.substring(0, i+1))){
              cur.add(0, s.substring(0, i+1)); // EDIT 2: Add to beginning of list
              backTrack(result, cur, s.substring(i+1, s.length()));
              cur.remove(s.substring(0, i+1));
          }
      }
  }

  private boolean isPalindrome(String s) {
      int start = 0, end = s.length() - 1;
      char[] schars = s.toCharArray();

      while(start < end){
          if(schars[start] != schars[end])
              return false;
          start++;
          end--;
      }
      return true;
  }
}