import java.util.Map;
import java.util.HashMap;

public class StackOverflowTest {
  public static void main(String args[]){
    Map<Integer,Integer> translateMap = new HashMap<>();
    translateMap.put(1,11);
    translateMap.put(2,23);
    translateMap.put(3,14);

    Integer userInput = 2;

    System.out.println("translated " + userInput 
                        + " into " + translateMap.get(userInput));

// prints: 
// translated 2 into 23
  }
}