Scanner input = new Scanner(System.in);
    while (true) {        
        String answer = input.next().toUpperCase();
        if (answer.equals("N")) {
            System.out.println("Thank you for playing!");
            // don't forget to close you scanner
            input.close();
            System.exit(0);
            break;
        } else if (answer.equals("Y")) {
            System.out.println("Starting a new game");
            MineSweeper game;
            game = new MineSweeper();
            input.close();
            break;
        } else {
            // if you don't get appropriate answer from users then warn them about it
            System.out.println("Please type either Y or N");
        }
    }