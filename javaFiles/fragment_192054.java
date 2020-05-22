public void patternMaker(int x, int direction){
    // Direction is either +1 or -1, depending on whether you go up or down
    // at the moment. Once you reach 3, switch the sign;
    // Once you reach zero, stop.

    // Pseudocode:
    // If x is zero, we're done
    // Print x asterisks followed by newline
    // if x == 3, make direction -1
    // Perform the recursive call with (x+direction, direction)
}