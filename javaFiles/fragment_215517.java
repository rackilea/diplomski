// Assume numShips, mainX, and shipLength have already been declared 
 int[] shieldX = new int[numShips];
 // Determine if odd or even number of ships
 boolean isOdd = numShips % 2; 
 if (isOdd) {
     // Middle shield ship index will be aligned with main Ship
     int mid = (numShips - 1)/ 2;
     shieldX[mid] = mainX; 
     // Place the ships on right and left sequentially. 
     for (int i = 1; i <= mid; i++) {
         // Calculate offset for every pair of ships.
         int offset = i * shipLength;
         shieldX[mid - i] = mainX - offset;
         shieldX[mid + i] = mainX + offset;
     }
} else {
    // First calculate the half length of the ships. 
    int half = shipLength / 2; 
    // Left Middle shield ship index will be half aligned with main Ship
    int midL = numShips / 2 - 1; 
    // Right middle shield ship index will be half aligned with main ship
    int midR = numShips / 2;
    // If we are even, then we can go straight into the for loops, similar to above
    for (int i = 0; i < midR; i++) {
        // Again calculate offset. This time include half lengths.
        int offsetL = i * shipLength + (shipLength / 2);
        // Now set values
        shieldX[midL - i] = mainX - offset;
        shieldX[midR + i] = mainX + offset;
    }
}