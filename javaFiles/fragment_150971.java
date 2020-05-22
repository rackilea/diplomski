Scanner input = new Scanner(System.in);
char guess;
int i = 0;
int spaces = 0;
int correct = 0;
int wrong = 0;
boolean run = true;

for (int i = 0; i < dashedarray.length; i++) {
    spaces++;        
}

while (run) {
    System.out.println("Enter your guess.");
    guess = input.next().charAt(0);

    boolean match = false;
    for (int j = 0; j < dashedarray.length; j++) {
        if (dashedarray[j] != ' ') {
            if(moviename.charAt(j) == guess)  {
                dashedarray[j] = guess;
                correct++;
                match = true;
            }
        }
    }

    // It matched nothing, this input is wrong.
    if (!match) {
        wrong++;
    }

    PrintArray(dashedarray);

    if (correct == (moviename.length() - spaces)) {
        System.out.println("You have won.");
        break;
    } else if (wrong == 10) {
        System.out.println("You have lost.");
        break;
    }
    System.out.println("The number of wrong guesses is " + wrong + ".");
}