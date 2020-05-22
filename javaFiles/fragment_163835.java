public Puzzle (int[] puzzle) { 
    //this creates a deep copy
    this.puzzle = new int[puzzle.length];
    for (int i = 0; i < puzzle.length; ++i) {
        this.puzzle[i] = puzzle[i]; 
    }        
}