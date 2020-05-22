public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String inputString;
    char flag = 'y';
    int matrix[][];
    while (flag != 'q' && flag != 'Q') {
        System.out.print("Enter a positive integer:");
        int value = input.nextInt();
        System.out.printf("Enter q to quit or any other key to quit: ");
        if(value > 0){
            matrix = new int[value][value];
            displayOutput(matrix);
        }

        input.nextLine();
        inputString = input.nextLine();
        flag = inputString.charAt(0);
    }
}

private static void displayOutput(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {

        matrix[i][0] = i+1;
    }
    for (int j = 1; j < matrix.length; j++) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = matrix[i][0]*(j+1);
        }            
    }

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
            System.out.print(" "+matrix[i][j]);
        }
        System.out.println("");
    }

}
Input: 3
Outputs: 1 2 3
         2 4 6
         3 6 9