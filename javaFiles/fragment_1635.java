import java.util.Scanner;

//creating a class
public class Metoder {
    //defining instance fields. Those will be visible/accesible from all instance(not static) methods.
    private Scanner userInput;
    private String navn;
    private String bosted;

    //constructor - used to create an object of your Metoder class
    private Metoder(final Scanner userInput) {
        this.userInput = userInput;
    }

    //here do as little as possible. Initialize userInput, and create the object.
    public static void main (String[]args) {
        Scanner in = new Scanner(System.in);
        new Metoder(in).run();  //creating new object and running it(method name can be different).
    }

    //here you all your important stuff.
    private void run() {
        System.out.println("Skriv inn ditt navn:");
        navn = userInput.nextLine();  //navn is visible/accessible here as it is defined as instance field.
        System.out.println("Skriv inn ditt bosted:");
        bosted = userInput.nextLine();
        skrivHilsen();

        System.out.println("Skriv inn ditt navn:");
        navn = userInput.nextLine();
        System.out.println("Skriv inn ditt bosted:");
        bosted = userInput.nextLine();
        skrivHilsen();

        System.out.println("Skriv inn ditt navn:");
        navn = userInput.nextLine();
        System.out.println("Skriv inn ditt bosted:");
        bosted = userInput.nextLine();
        skrivHilsen();
    }

    //navn/bosted are visible/accessible here as they are defined as instance fields.
    private void skrivHilsen() {
        System.out.println("Hei, "+ navn +"! Du er fra "+ bosted +"." );
    }
}