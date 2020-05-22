byte table[][] = new byte[NUM_STATES][NUM_CHARACTERS];
// Populate the non-zero entries of the table
table[0]['b'] = 1;
table[1]['a'] = 2;
// etc...

private int transition(char current, int state) {
  return table[state][current];
}