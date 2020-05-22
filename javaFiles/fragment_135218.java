public class WordAverage{
   public static void main (String[] args) {

       String str="Hello World"; 
       double average=0; // you need only one double variable, why double -> because of the division later 
        // note that if you don't want the decimal you can change it to int
        for(char c : str.toCharArray()){ // cycle through every char in the String
            if(c!=' '){ // if it is not a space
               average += (int)c; // sum its value
            }
        }

       average /= str.replace(" ", "").length(); // then divide the average value by the String length after removing the spaces (if any)
        System.out.println(average);
    }
  }