static void calculatePercentage(){
    int numOfRolls = getNumOfRolls();

    int die1 = 0;
    int die2 = 0;
    int[] dieTotal = new int[13];

    for(int i = 0; i < numOfRolls; i++){
        die1 = rollDice();
        die2 = rollDice();
        int total = die1 + die2;

        dieTotal[total]++;

    }

    printPercentage(dieTotal, numOfRolls);
}