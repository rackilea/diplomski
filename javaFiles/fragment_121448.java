boolean isAlreadyHit = (internalGrid[urow][ucol] == 'H');
boolean isNewHit = (internalGrid[urow][ucol] == 'X');

if (isAlreadyHit) {
    System.out.println("You already hit that location");} 
}
else if (isNewHit) {
    System.out.println("Hit!");
    internalGrid[urow][ucol] = 'H';
} 
else {
    System.out.println("Miss!");
}

boolean isWinner = true;
for (int row = 0; row < internalGrid.length; row++) {
    for (int col = 0; col < internalGrid[row].length; col++) {
        if (internalGrid[row][col] == 'X') {
            isWinner = false;
        }
    }
}

if (isWinner) {
     System.out.println("You win!");
     break;  // breaks out of the outer for loop
}