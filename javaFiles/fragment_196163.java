// Type changed to bool, removed throws:

public static bool solve(Field f, int i, int j) {

    System.out.print(f+"\n");

    if ( j >= Field.SIZE) {

        //we are done (return true now!)
        return true;

    } 

    if (f.isEmpty(i, j)) {

        for (int val = 1; val <=9; val++) {

            if (f.tryValue(val, i, j)){

                if (j>=Field.SIZE-1){

                    if( solve (f, i+1, 0) ){
                        // This halts the loop here:
                        return true;
                    }

                    f.clear(i, j);

                } else {

                    if( solve(f,i,j+1) ){
                        // This halts the loop here:
                        return true;
                    }

                    f.clear(i, j);

                }

            }
        }

    } else if (j>=Field.SIZE-1) {

        // (Side note: This one is tail recursion)
        return solve(f,i+1,0);

    }

    // (Side note: This one is tail recursion)
    return solve(f,i,j+1);

}