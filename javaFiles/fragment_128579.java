public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);


    int lines = sc.nextInt();
    int[][] input = new Integer[lines][]; //This is the matrix we are building

    for(int i = 0; i < lines; i++){       //For each row of numbers
        int size = sc.nextInt();          //Find out how many numbers on this row
        input[i] = new int[size];         //Create array of this size for this row
        for(int x = 0; x < size; x++){    //For each number on this row
            input[i][x] = sc.nextInt();   //Read it into the correct row,col positon
        }
    }

    sc.close();

    //Do printing
    for(int[] row : input){
        int lastElm = row[row.length - 1];
        System.out.println(row[lastElm - 1]);
    }
}