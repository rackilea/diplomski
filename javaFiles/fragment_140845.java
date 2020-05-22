public class YourClass {

    public String getInput() {
        //from standard input or whatever
    }

    public String getOutputFromInput(String input) {
        //do your logic here        
        if ("10".equals(input)) {
            return "Thank you, now starting...";
        }
        //else... or whatever
    }

    public void printOutput(String output) {
        System.out.println(output);
    } 

}