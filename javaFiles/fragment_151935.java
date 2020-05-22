/*  @param thisRow the number of asterisks in the next row to be printed */
/*  @param needed the number of asterisks in the widest row of the diamond */
void printDiamond(int thisRow, int needed) {
  if (thisRow >= needed) {
    // the row has as many (or more) than we need.
    // terminate recursion.
    for (int i = 0; i < needed; i++) {
       System.out.print("*");
    }
  } else {
    // the row is less than what we need.
    // print out the row.
    for (int i = 0; i < thisRow; i++) {
       System.out.print("*");
    }
    // print out the middle
    printDiamond(thisRow+1, needed);
    // print out the row.
    for (int i = 0; i < thisRow; i++) {
       System.out.print("*");
    }
}