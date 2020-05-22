int nonConsecCount = 0;
        for(int currDice = 0; currDice < N_DICE - 1; currDice++) {
            if(dices[currDice] + 1 != dices[currDice + 1]) {
                System.out.println("failed consecutive match!");
                nonConsecCount++;
            } else {
                System.out.println("passed consecutive match for "+ dices[currDice]);
            }
        }
        System.out.println(nonConsecCount);