int shiftBy = 3;
 int[] imageRow = ...
 int shiftCarry = 0;
 // The last shiftBy bits are set to 1, the remaining ones are zero
 int mask = (1 << shiftBy)-1;
 for (int i = 0 ; i != imageRow.length ; i++) {
     // Cut out the shiftBits bits on the right
     int nextCarry = imageRow & mask;
     // Do the shift, and move in the carry into the freed upper bits
     imageRow[i] = (imageRow[i] >>> shiftBy) | (carry << (32-shiftBy));
     // Prepare the carry for the next iteration of the loop
     carry = nextCarry;
 }