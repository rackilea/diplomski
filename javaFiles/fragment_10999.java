public class ClassName{
    private Player codeMaker;

    public void setupPlayers() {
        System.out.println("Would you like the Code Maker to be Human or CPU? :");
        String input = mySc.next();
        if (input.equals("Human")) {
            codeMaker = new Human();
        }
        else {
            codeMaker = new CPU();  
        }
    }

    public void exampleUse() {
         codeMaker.getCode();
    } 
}