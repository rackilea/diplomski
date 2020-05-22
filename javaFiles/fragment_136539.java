public boolean someName(boolean shouldSwap) {
    int a = 0; //index of one card
    int b; //index of second card
    for (b = getSize() - 1; b > 0; b--) {
        for (a = 0; a < b; a++) {
            if (isCorrectMove(a, b)) {
                if (shouldSwap)
                    swap(a, b); //makes move
                return true; //exit after move
            }
        }
    }
    return false; //if there was no move
}