private static int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

public static void step(int[][] array, int x, int y) {

     if(array[x][y] == 0){
         array[x][y] = 1;
     }else{
         return;
     }
    int number = 1;
    while(true){
        printGrid(array);
        int amount = process(array, x, y);
        if(amount == 1)break;
        number ++;
        array[x][y] = number;
    }
}

public static int process(int[][] array,int x, int y){
    int number = array[x][y];
    if(number == 0) return 0;
    int total = 1;
    array[x][y] = 0;
    for(int[] dire:directions){
        if(x + dire[0] >= 0 && x + dire[0] < array.length && y + dire[1] >= 0 && y + dire[1] < array[0].length){
            if(array[x + dire[0]][y+dire[1]] == number){
                total += process(array, x + dire[0], y+dire[1]);
            }
        }
    }
    return total;
}


public static void printGrid(int[][] grid) {
    for(int i = 0; i < grid.length; i++){
        String s = "";
        for(int n = 0; n<  grid[0].length; n++){
            s += grid[i][n]+", ";
        }
        System.out.println(s);
    }
    System.out.println("");
}

public static void main(String[] args){
    int [][] grid =
            {{2, 0, 0, 1, 1, 2},
            {1, 0, 2, 0, 0, 1},
            {1, 0, 2, 0, 4, 2},
            {8, 3, 4, 0, 1, 2},
            {1, 2, 5, 0, 3, 3},
            {5, 1, 1, 2, 1, 0}};

    Main.step(grid, 2,1);

   printGrid(grid);