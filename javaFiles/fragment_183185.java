public static double[][] array1 = // array to be used
    { { 7.51, 9.57, 6.28, 5.29, 8.7 }, { 8.07, 6.54, 5.44, 8.78, 8.66 }, { 9.34, 9.73, 7.19, 6.87, 6.48 } };

    public static void main(String[] args) {

        //loop through each row
        for(int x = 0; x<array1.length; x++){
            //make sure not empty (won't be an issue with the supplied array, but could be)
            if(array1[x].length > 0){
                //take the number as a starting place for your highest index
                //you don't want to pick 0 as the highest number in case all of the numbers are negative
                int highestIndex = 0;
                double highestNumber = array1[x][0];

                //look at the rest of the numbers and see if there are any that are higher
                for(int y = 1; y<array1[x].length; y++){
                    if(array1[x][y] > highestNumber){
                        highestIndex = y;
                        highestNumber = array1[x][y];
                    }
                }

                //set whatever is the highest to 0
                array1[x][highestIndex] = 0;
            }
        }

        System.out.println(); // print array with highest values in each row now
                                // changed to zero
        for (int x = 0; x < array1.length; x++) {
            System.out.println();
            for (int y = 0; y < array1[x].length; y++) {
                System.out.print(array1[x][y] + " ");
            }
        }
    }