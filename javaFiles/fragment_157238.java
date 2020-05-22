public void print(double [][] salesArray) 
{
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    for (int i = 0; i < salesArray.length; i++) {
        double sum = 0.0;
        for (int j = 0; j < salesArray[0].length; j++) {
            sum += salesArray[i][j];
        }
        System.out.println(sum);
    }
}