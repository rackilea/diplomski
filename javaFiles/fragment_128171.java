for (int m = 0; m < numRolls; m++)
    {
        combo[dice1[m] - 1][dice2[m] - 1]++;
    }

    for (int m = 0; m < numRolls; m++)
    {
        if (combo[dice1[m] - 1][dice2[m] - 1] > 1)
        {
            System.out.println("You rolled: " + dice1[m] + " and " + dice2[m] + " a total of " + combo[dice1[m] - 1][dice2[m] - 1]   + " time(s)");
            combo[dice1[m] - 1][dice2[m] - 1] = 0;
        }

        if (combo[dice1[m] - 1][dice2[m] - 1] == 1)
        {
        System.out.println("You rolled: " + dice1[m] + " and " + dice2[m] + " a total of " + combo[dice1[m] - 1][dice2[m] - 1] + " time(s)");
        }
    }