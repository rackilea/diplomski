public class Solution {
 public static void main(String[] args) 
    {

       String[] tokens = "He is a very very good boy, isn't he?".split("[ |!|,|\\?|\\.|_|'|@|]+");
       for(String token : tokens){
       System.out.println(token);
       }
      }
     }