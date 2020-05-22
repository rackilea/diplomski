while (true) {

            try {
                int randomNumberOne = ThreadLocalRandom.current().nextInt(10, 21); //generates a number between 10 and 20
                int randomNumberTwo = ThreadLocalRandom.current().nextInt(10, 21); //generates a number between 10 and 20
                System.out.println("Type and enter \"q\" to quit at any time \n \n");

                System.out.println(randomNumberOne + " % " + randomNumberTwo + " = ?"); //prints the question

                Scanner userInput = new Scanner(System.in);
                String remainderInputStr = userInput.nextLine();
                if (remainderInputStr.equalsIgnoreCase("q")) {
                    System.exit(0);
                }
                int remainderInput = Integer.parseInt(remainderInputStr);
                if (remainderInput == randomNumberOne % randomNumberTwo) { //if they get the question right
                    userScore += 20; //adds 20 points
                    performance += 1; //adds 1 to the correct question counter
                    performancetotal += 1; //adds 1 to the total question counter
                    System.out.println("Correct answer, Current Score: " + userScore + ", performance: " + performance + "/" + performancetotal + "\n");
                    continue;
                } else { //if they get the question wrong
                    userScore += 0; //adds no points
                    performance += 0; //adds nothing to correct question counter
                    performancetotal += 1;
                    System.out.println("Incorrect answer, Current Score: " + userScore + ", performance: " + performance + "/" + performancetotal + "\n");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input\n");

            }