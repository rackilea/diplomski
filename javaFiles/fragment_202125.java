int actNum = 0;
    while (!account.hasNextInt()) {
        // Out put error
        System.out.println("Invalid Account number. Please enter only digits.");
        account.next();//Go to next
    }
    actNum = account.nextInt();