public class NewIOException extends IOException{
    public NewIOException () {
        super("Input Error");
        // though it's a bad practice to
        // have this logic in the exception class
        System.out.println("Input new letter from a - z: ");
        Guess.userInput(); 
    }
}