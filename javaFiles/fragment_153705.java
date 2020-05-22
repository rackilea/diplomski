private int computerTryHorizontalPlay() {
    return computerTryHorizontalPlay(true);
}

private int computerTryHorizontalPlay(boolean doMove) {

    // lots of code here

    if (repeatedMyValueCount > 0) {
        if (doMove)
            jogoGalo[myPositions[0]][myPositions[1]] = 'X';
        return 2;
    } else if (repeatedYourValueCount > 0) {
        if (doMove)
            jogoGalo[yourPositions[0]][yourPositions[1]] = 'X';
        return 1;
    }

    return 0;
}

public String toString() {
    if(computerTryHorizontalPlay(false) == 3) {
        return "The game has already ended!";
    }
    else if(computerTryHorizontalPlay(false) == 2) {
        return "Computer won!";
    }
    else if(computerTryHorizontalPlay(false) == 1) {
        return "Computer defeated!";
    }
    return null;
}