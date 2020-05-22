public abstract class AbstractStringGenerator{

     // marked as final. Subclasses cannot override this behavior
     public final String generateLine(String input){
         String result = generateLineHook(input);
         //do contract checking...
         //if new line char is not the last char, then throw contract exception...
         if(!result.endsWith("\n")){
             throw new IllegalStateException("Result from hook does not contain new line");
         }
         return result;
     }
    /**
     * This method must return a new line as it's last char
     * @return string output
     */
     protected abstract string generateLineHook(String input);
}


public class ConcreteStringGenerator{

    /**
     * This method overrides the beh
     * @return string output
     */
     protected String generateLineHook(String input){
         return "blah\n";
     }
}