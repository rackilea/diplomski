//Rules as an array of [from, to, index] definitions 
  int[][] rules = {
    {  1,  4,  1 },
    {  5,  7,  2 },
    {  8, 10,  3 }
  };

  for (int[] rule : rules)
  {
    if ((number >= rule[0]) && (number <= rule[1])) {
      index = rule[2];
      break;
    }
  }