import java.io.*;
//class declaration here

public static void main(String[] args) {
    System.out.println(guessTheNumber());
}

public String guessTheNumber() {
    int guess;
    System.out.print("Guess the number:_");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
        guess = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e) {
        System.err.println("You didn't guess a number.");
        guessTheNumber();
    } catch (IOException e) {
        System.err.println("An unexpected error occured. Please try again.");
        guessTheNumber();
    }
    if (guess == 4) {
        return "YAY! You get a prize!";
    } else {
        System.err.println("WAAHH! You get to guess again!");
        guessTheNumber();
    }
}