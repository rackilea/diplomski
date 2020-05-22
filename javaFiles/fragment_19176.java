boolean error3 = false;
    do {
        String Choice = input.nextLine();
        String Balance = "Balance";
        String Game = "Game";
        input.close();

        boolean error1 = ! new String(Choice).equals(Game);
        boolean error2 = ! new String(Choice).equals(Balance);
        error3 = error2 || error1;