/**
* This method will take each row from the supplied 2D double type array1 and
* each row from the supplied 2D double type array2 and display the 
* Kullback–Leibler Divergence for each of those rows of data processed.<br><br>
* 
* Note: This method outputs its results into the Console Window.<br><br>
*
* Note: This method utilizes <b>Charles Sutton's</b> method named klDivergence() to
* acquire Kullback–Leibler Divergence values.<br><br>
* 
* @param array1 (2D Double Type Array)<br>
* 
* @param nameForArray1 (String) The string name to use for array1 for console 
* display purposes.<br>
* 
* @param array2 (2D Double Type Array)<br>
* 
* @param nameForArray2 (String) The string name to use for array2 for console 
* display purposes.
*/
private void kldFromDoubleArrays(double[][] array1, String nameForArray1, 
        double[][] array2, String nameForArray2) {
    //Iterate through Rows of array1...
    for (int i = 0; i < array1.length; i++) {
        //Declare a 1D Array to hold current row from array1
        double[] p0 = new double [array1[i].length];

        //Iterate through Columns of current array1 Row...
        for (int j = 0; j < array1[i].length; j++) {
            //Place current array1 row into a 1D Array p0
            p0[j] = array1[i][j];

            //Iterate through Rows of array2...
            for (int k = 0; k < array2.length; k++) {
                //Declare a 1D Array to hold current row from array2
                double[] p1 = new double[array2[k].length];

                //Iterate through Columns of current array2 Row...
                for (int l = 0; l < array2[k].length; l++) {
                    //Place current array2 row into a 1D Array p1
                    p1[l] = array2[k][l];

                    //Get the KL Divergence fpr p0 and p1 1D arrays
                    //and display it within the Console window
                    double kld = klDivergence(p0, p1);

                    //Display to Console
                    System.out.println("The Divergence between Row " + i + 
                            " of " + nameForArray1 + " and Row " + k + " of " +
                            nameForArray2 + " is: -->  " + kld);
                } 
            }
        }
    }
}