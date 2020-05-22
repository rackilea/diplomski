public class Automata { // we use upper case for class names

   public String input; // or better private and use a get-method

   public Automata() {} // constructor

   public boolean readUserInput() { // lower case here
        System.out.println("Please enter test data: ");
        Scanner user_input = new Scanner(System.in);
        String nextInput = user_input.next();
        input += nextInput; // otherwise you overwrite your current input
        /*if (accepts(input) == true){
            System.out.print("works");
            // return true;
        } else { 
            System.out.println("Problem");
            return false;
        }*/
        // It is a terrible idea to return every time a single word is read
        // rather read the whole String and then check if it is accepted
        if (accept(input)) // whole String is checked
            return true;
        return false;
    }
    // in case the input variable is private
    public String getInput() {
         return input;
    }
}