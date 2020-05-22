Integer[] gridInts = grid.toArray(new Integer[0]);
StringBuilder output = new StringBuilder();

for (int index = 0; index < gridInts.length; index++) {
   int row = index / 5;
   int col = index % 5;

   String cell = (row == 2 && col == 2) ? "--" : gridInts[index].toString();
   output.append(" | ").append(cell);
   if (col == 4) output.append(" |" + "\\n");  // causes a new line to start
                                               // after the last column in the grid
}

String result = output.toString();             // gets String from StringBuilder
System.out.println(result);                    // sends grid to standard output