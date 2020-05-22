askQuestion(); 

while (true) {

    userChoice = getAnswer();

    switch(userChoice)
    {
        case 'a':
        case 'A':
            System.out.println("Incorrect! 'Switch' IS a key word. The correct answer was B. ");
            System.out.println("The program will now end. Thanks for answering!");
            System.exit(0);

        ...

        default:
            System.out.println("Invalid character.");
    }
}