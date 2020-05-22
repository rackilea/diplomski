public double[] columnSum(double [][] array){

    int size = array[0].length; // Replace it with the size of maximum length inner array
    double temp[] = new double[size];

    for (int i = 0; i < array.length; i++){
        for (int j = 0; j < array[i].length; j++){
            temp[j] += array[i][j];  // Note that, I am adding to `temp[j]`.
        }
    }

    System.out.println(Arrays.toString(temp));
    return temp;  // Note you are not using this return value in the calling method
}