public static void main(String args[]){

    int arr[][] = {{1,3,5}, {2,4,6}, {7,8,9}};

    for(int i=0; i < 3; i++){
        for(int j=0; j < 3; j++){

            if (i == 0             // in the first row
                || i == 2      // in the last row
                || j == 1) {   // in the middle column of the middle row

                System.out.print(arr[i][j]+" ");

            } else {

                System.out.print("  ");    // this is here to keep the spacing right

            }
            //System.out.println();
        }

        System.out.println();
    }

}