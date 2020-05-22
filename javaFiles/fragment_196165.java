// Type changed to void, added our solver arg:

public static void solve(Field f, int i, int j, SudokuSolver solver) {

    System.out.print(f+"\n");

    if ( j >= Field.SIZE) {

        //we are done (return true now!)
        solver.done=true;
        return;

    } 

    if (f.isEmpty(i, j)) {

        for (int val = 1; val <=9; val++) {

            if (f.tryValue(val, i, j)){

                if (j>=Field.SIZE-1){

                    solve (f, i+1, 0, solver);

                    if ( solver.done ) {

                        // This halts the loop here:
                        return;
                    }

                    f.clear(i, j);

                } else {

                    solve(f,i,j+1, solver);

                    if ( solver.done ) {

                        // This halts the loop here:
                        return;
                    }

                    f.clear(i, j);

                }

            }
        }

    } else if (j>=Field.SIZE-1) {

        solve(f,i+1,0, solver);

    } else {

        solve(f,i,j+1, solver);

    }

}