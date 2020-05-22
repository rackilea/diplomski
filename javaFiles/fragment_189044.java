int border[][] = new int[3][3];
int space[][] = new int[3][3];
for (int[] b : border) {  // <-- lets first create border arrays
  b[0] = b[2] = 1;        // <-- combine the 1s.
  b[1] = 0;              
}
for (int[] s : space) {   // <-- now space arrays
  s[0] = s[1] = s[2] = 1; // <-- combine the 1s.
}
// Now border and space are setup
for (int i = 0; i < border.length; i++) { 
  for (int j = 0; j < border[0].length; j++) {
    if(border[i][j] == 1) {
        System.out.print("|");
    } else { // <-- You need an else block
      System.out.print(" ");          
    }
    if(space[i][j] == 1){ // <-- space is pointless. This is always true.
        System.out.print("   ");
    }
  }
  System.out.println(); // <-- new line.
}