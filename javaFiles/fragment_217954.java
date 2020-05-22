for (int[] columnWinner : winner) { // traverses all cases
    if ( // if there is a case satisfied
       // for a specified case for example {0, 1, 2}
        playerChoices[columnWinner[0]] == playerChoices[columnWinner[1]] && // check if choice at 0 is the same as choice at 1
        playerChoices[columnWinner[1]] == playerChoices[columnWinner[2]] && // check if choice at 1 is the same as choice at 2
        // then choice at 0 1 2 are the same
        playerChoices[columnWinner[0]] != Player.NO // and this "the same" is not "they are all empty"
    ) { 
    // then there is a winner