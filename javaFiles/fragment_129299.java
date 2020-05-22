public class Example {

    int variableOne;
    int variableTwo;

    public int variableResultFromUserInput() {
        return this.variableOne * this.variableTwo;
    }

    public static void main(String[]args) {
        Example myExample = new Example();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your variable one? ");
        myExample.variableOne = keyboard.nextInt(); //this is the variable that causes trouble

        System.out.println("Whats your variable two?");
        myExample.variableTwo = keyboard.nextInt(); //this is the second variable that causes trouble

        System.out.println(myExample.variableResultFromUserInput()); //this is also wrong
    }
}