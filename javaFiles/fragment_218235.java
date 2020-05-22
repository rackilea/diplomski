public static void Diamond() {
    int DIAMOND_SIZE = 5;
    System.out.println("Diamond Height: " + DIAMOND_SIZE);
    System.out.println("Output for: For Loop");

    int noOfRows = DIAMOND_SIZE;

    //Getting midRow of the diamond
    int midRow = (noOfRows)/2;

    //Initializing row with 1
    int row = 1;

    int i = midRow;
    while(i > 0){
        //Printing i spaces at the beginning of each row
        int j = 1;
        while(j <= i){
            System.out.print(" ");
            j++;
        }

        //Printing j *'s at the end of each row
        j = 1;
        while(j <= row){
            System.out.print("* ");
            j++;
        }
        System.out.println();

        //Incrementing the row
        row++;

        i--;
    }

    i = 0;
    while(i <= midRow){
    //Printing i spaces at the beginning of each row
        int j = 1;
        while(j <= i){
            System.out.print(" ");
            j++;
        }

        //Printing j *'s at the end of each row
        int mid = (row+1) / 2;
        j = row;
        while(j > 0){
            if(i == 0 && j == mid)
                System.out.print("o ");
            else
                 System.out.print("* ");
            j--;
        }

        System.out.println();

        //Decrementing the row
        row--;
        i++;
    }
}