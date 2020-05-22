Scanner sca = new Scanner(System.in);

boolean incorrectInput = true;
int userInput = -1; // initialize as a negative  

while (incorrectInput) {

    if (sca.hasNextInt()) {
        int n = sca.nextInt();
        if (n < 0) {
            System.err.println("error_1");
        } else {
            // do anything else
            userInput = n;
            incorrectInput = false;
        }
    } else {
        sca.next();
    }
}

if (!incorrectInput) {
    System.out.println("UserInput = " + userInput);
}