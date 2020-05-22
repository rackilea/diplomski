public class StackOverflowTest {
  public static void main(String args[]){
    Integer userInput = 12;
    Integer translated;

    if (userInput > 20) {
      translated = 100;
    } else if (userInput > 10) {
      translated = 50;
    } else if (userInput > 0) {
      translated = 250;
    } else {
      translated = 10000; // replace with exception handling
    }

    System.out.println("translated " + userInput 
                        + " into " + translated);

// prints: 
// translated 12 into 50
  }
}