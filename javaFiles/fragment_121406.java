import java.io.*;  
    public class Solution {
        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new         
            InputStreamReader(System.in));
            String snumber = reader.readLine();
            int number = Integer.parseInt(snumber);
            if (number > 0)
              number = number * 2;
            else
              number = number + 1;
            System.out.println(number);
        }
    }