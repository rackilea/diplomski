String[] choices = {"() ",".  "}; //choices holds 2 members, () and .
Random rand = new Random();       //creates random method
int place = rand.nextInt(10);     // this is for the tree
for (int j = 0; j<4; j++){
    for (int i = 0; i < 10; i++) {                //executes the following loop 10 times
        if (j==3){                                //makes rocks and bushes print only on bottom line
            int NumberOfAnswers = choices.length;     //holds value of number of members in choices
            int pick = rand.nextInt(NumberOfAnswers); // picks random int 0 or 1
            String finalChoice = choices[pick];       //"finalChoice" is either member 0 or 1 of choices
            System.out.print(finalChoice);            // prints "finalChoice"
        } else {
            System.out.print("   ");
        }
        if (i == place && j == 0) {                 //if it's the designated place and the top row...
            System.out.print(" ^  ");               //...print the top of the tree
        } else if (i==place && (j == 1||j == 2)) {  //if it's the designated place in the 2nd or 3rd rows...
            System.out.print("/|\\ ");              //...print the body of the tree
        } else if (i == place && j == 3){           //if its the designated place and the last row
            System.out.print(" |  ");               //...print the base of the tree
        }
    }   
    System.out.println();                         //start a new line
}