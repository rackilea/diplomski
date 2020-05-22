public class AdderGame {
    public static void main (String [] args){
        int ans = 0;
        int guess = 0;
        int tries;
        int score = 0;

        Player one = new Player (0 , 0);
        while (guess != 99) {
            tries = one.getTry();
            ans = one.getAns();
            guess = one.getGuess(); // notice I'm getting the guess
            switch (tries) {
            case 1: score += 5; break;
            case 2: score += 3; break;
            case 3: score += 1; break;
            case 4: score += 0;
            System.out.print("The right answer is "); break;
            }
        }

        System.out.print("Your Score is " + score);
    }
}

// Methods from inside of your Player class
public int getTry(){
    Scanner input = new Scanner(System.in);
    ran1 = (int) (19 * Math.random());
    ran2 = (int) (19 * Math.random());
    answer = ran1 + ran2;

    do {
        System.out.print(ran1 + " + " + ran2 + ": ");
        guess = input.nextInt();
        if (guess == answer) {
            return (tries);
        } else {
            tries += 1;
        }
    // Notice that it's now `&& guess != 99` instead of `||`
    } while (tries <= 4 && answer != guess && guess != 99);
    return (tries);
}
// new getter for getting the guess
public int getGuess(){
    return guess;
}