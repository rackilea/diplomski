public class Filter {

      public static void main(String[] args) throws IOException { 
           Automata automata = new Automata();
           if (automata.readUserInput()) {
                // BufferedReader in4 = new BufferedReader(new StringReader(automata.getInput())); or automata.input in case it is public
                // I don't understand why you want to read the input here again step by step
                // rather read the whole input here
                String userInput = automata.getInput();
           }
      }
 }