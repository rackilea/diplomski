// ask user for sizes
  int col = ...;
  int row = ...;

  // declare the array, let it be of type int 
  // it's the last occurence of "row" and "col"
  int[][] data = new int[row][col];

  // loop the array    
  for (int r = 0; r < data.length; ++r) { // <- not "row"!
    int[] line = data[r];

    for (int c = 0; c < line.length; ++c) { // <- not "col"!
      // do what you want with line[c], e.g. 
      // line[c] = 7; // <- sets all array's items to 7
    }
  }