private static void convert(double amount) {
        int toonies;
        int loonies;
        int quarters;
        int dimes;
        int nickels;
        int remainingCents;

        remainingCents = (int) (amount * 100 + .5);
        toonies = remainingCents / 200;
        remainingCents %= 200;
        loonies = remainingCents / 100;
        remainingCents %= 100;
        quarters = remainingCents / 25;
        remainingCents %= 25;
        dimes = remainingCents / 10;
        remainingCents %= 10;
        nickels = remainingCents / 5;
        remainingCents %= 5;

        System.out.println("toonies:" + toonies + ";" + " loonies:" + loonies + ";" + " quarters:" + quarters + ";"
                + " dimes:" + dimes + ";" + " nickels:" + nickels + ";" + " remainingCents:" + remainingCents);
        System.out.print("Enter a dollar amount:");

    }