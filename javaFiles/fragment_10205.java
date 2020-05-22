int[][]histogram = new int[11][11];
for(int x = 0; x < total_rolls; x++){
  int dice1 = roll(sides); //result of dice 1 (1-11)
  int dice2 = roll(sides); //result of dice 2 (1-11)
  histogram[dice1-1][dice2-1]++; //increment the frequency of this event
}

double prob = 1.0*histogram[5][9]/total_rolls; //probability of combination (6,10)