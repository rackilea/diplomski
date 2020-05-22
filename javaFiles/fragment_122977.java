// creates fixed size 2D array with zeros
    int [] [] x = new int [50][50]; 

    // creates empty vector of vectors of integers
    // y is of type Vector<Vector<Integer>>
    // y.get(row) is of type Vector<Integer>>
    // y.get(row).get(col) is of type Integer
    Vector<Vector<Integer>> y = new Vector<Vector<Integer>>(); 

    // set the size of vector of vectors (number of rows)
    // each row will be null for now
    y.setSize(x.length);

    // enumerating rows
    for(int row=0; row<x.length; ++row) {

        log.info("row {}", row);

        // assign empty vector for row
        y.set(row, new Vector<Integer>());

        // set row size (number of columns)
        y.get(row).setSize(x[row].length);

        // enumerating columns of current row
        for(int col=0; col<x[row].length; ++col) {

            // setting the value for a cell
            y.get(row).set(col, x[row][col]);

        }
    }