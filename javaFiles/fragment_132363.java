Random rand = new Random();
int numOfRolls = 0; //starts at zero for the number of rolls
int x;
int y;
int z;
do {
  numOfRolls++;
  x = rand.nextInt(6) + 1;
  y = rand.nextInt(6) + 1;
  z = rand.nextInt(6) + 1;
} while (x == y || y == z || x == z);