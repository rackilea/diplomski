SudokuSolver solver=new SudokuSolver();

solve(field, 0, 0, solver);

if ( solver.done ) {
    // It was solved!
}