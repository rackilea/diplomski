Solution findSolution(Board board) {
    if (board.isSolved()) return solutionFor(board);


    // An "action" here refers to placing any number 
    // on any free field
    for (each possible action) {

        do the action // That is: place a number on a free field

        // The recursion:
        Solution solution = findSolution(board);
        if (solution != null) return solution;

        // No solution found
        UNdo the action // That is: remove the number from the field

        // Now the loop continues, and tries the 
        // next action...
    }

    // Tried all possible actions, none did lead to a solution
    return null;
 }