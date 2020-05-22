public static void calculateChange(float moneyGiven, float total) {
    float changeTotal = moneyGiven - total;

    int wholeDollars = (int) Math.floor(changeTotal);

    int quarters = (int) Math.floor((changeTotal - wholeDollars)/.25);

    int dimes = (int) Math.floor(((changeTotal - wholeDollars) - quarters * .25)/.1);

    int nickles = (int) Math.floor(((changeTotal - wholeDollars) - quarters * .25 - dimes * 0.1)/.05);

    int pennies = (int) Math.floor(((changeTotal - wholeDollars) - quarters * .25 - dimes * 0.1 - nickles * .05)/.01);

    System.out.println(wholeDollars + " " + quarters + " " + dimes + " " + nickles + " " + pennies);
 }