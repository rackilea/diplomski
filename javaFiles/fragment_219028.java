public static void main(String []args){
    System.out.println("Welcome to the game Merge Numbers. Your grid as follows:");
    int[][] newGrid = {{2, 0, 1, 1, 0, 8}, 
                      {2, 1, 0, 2, 4, 0}, 
                      {1, 2, 1, 2, 1, 3}, 
                      {2, 3, 2,0, 1, 0}, 
                      {0, 0, 5, 8, 7, 2}, 
                      {2, 0, 1, 1, 0, 0}};
    for(int i = 0 ; i < newGrid.length ; i++){
        for (int j = 0; j < newGrid[i].length; j++) {
            System.out.print(newGrid[i][j] + " ");
        }
        System.out.println();
    }
    try (Scanner keyboard = new Scanner(System.in)){
    System.out.print("Please enter your target's row index:");
    int newRow = keyboard.nextInt();
    System.out.print("Please enter your target's column index:");
    int newColumn = keyboard.nextInt();
    System.out.print("Please enter the number that you want to add to location " + newRow +  " " +  newColumn);
    int newNextNumber = keyboard.nextInt();
    step(newGrid, newRow, newColumn, newNextNumber);
    for(int i = 0 ; i < newGrid.length ; i++){
        for (int j = 0; j < newGrid[i].length; j++) {
            System.out.print(newGrid[i][j] + " ");
        }
        System.out.println();
    }}
}

public static void step(int[][] grid, int row, int column, int nextNumber ) {

     if(grid[row][column] == 0){
         grid[row][column] = nextNumber;
     }else{
         return;
     }
     int number = nextNumber;
    while(true){
        int amount = process(grid, row, column);
        if(amount == 1)break;
        number ++;
        grid[row][column] = number;
    }
}

public static int process(int[][] grid,int row, int column){
    int number = grid[row][column];
    if(number == 0) return 0;
    int total = 1;
    grid[row][column] = 0;
    for(int[] dire:directions){
        if(row + dire[0] >= 0 && row + dire[0] < grid.length && column + dire[1] >= 0 && column + dire[1] < grid[0].length){
            if(grid[row + dire[0]][column+dire[1]] == number){
                total += process(grid, row + dire[0], column+dire[1]);
            }
        }
    }
    return total;
}