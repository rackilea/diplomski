import java.util.Map;
import java.util.HashMap;

public class StackOverflowTest {
  public static void main(String args[]){
    Map<Integer,Integer> translateMap = new HashMap<>();
    translateMap.put(0,250);
    translateMap.put(1,50);
    translateMap.put(2,100);
    translateMap.put(3,5);

    String userInput = "19";

    // Converting a string into an Integer
    Integer input = Integer.parseInt(userInput);
    Integer translated;

    // works to replace below if statement only 
    // because ranges happens to be devided into 10's
    translated = translateMap.get(input/10); // automatic flooring of float to int.

/*
    if (input > 20) {
      translated = translateMap.get(2);
    } else if (input > 10) {
      translated = translateMap.get(1);
    } else if (input > 0) {
      translated = translateMap.get(0);
    } else {
      translated = 10000; // exception handling
    }
*/

    System.out.println("translated " + userInput 
                        + " into " + translated);

// prints: 
// translated 19 into 50
  }
}