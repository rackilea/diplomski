boolean validCondition = false;

    do {
        System.out.println("Question #1:");
        System.out.println("What is your budget for purchasing the laptop?");

        System.out.println("A. >$500.00");
        System.out.println("B. $500.00 - $700.00");
        System.out.println("C. $700.00 - $1000.00");
        System.out.println("D. <$1000.00");

        questionArray[0] = myScanner.nextLine();

        validCondition = questionArray[0].equals("A") || questionArray[0].equals("B") || questionArray[0].equals("C")
                || questionArray[0].equals("D");

        if (!validCondition) {
            System.out.println("Invalid Entry");
        }
    } while (!validCondition);