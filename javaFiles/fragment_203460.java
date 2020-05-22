int counter = 1;//counter for number of rolls. Initialized at 1 because dice object is rolled upon construction.

            //get die1 and die2
            while(dice.getDie1() + dice.getDie2() != i){

                dice.roll();
                counter ++;

            }