int cols = 15;
int rows = 20;

Random rand = new Random();

int[][] myArray = new int[rows][cols];

for (int i=0; i < myArray.length; i++) {
    for (int j=0; j < myArray[i].length; j++) {
        myArray[i][j] = rand.nextInt(2);
        System.out.print(" " + myArray[i][j]);
    }
    System.out.println("");
}