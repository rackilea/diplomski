class Arrays {
    public static void main(String[] args) {
        double[] alpha = new double[50];

        for(int i = 0; i < alpha.length; i++)
        {
            // between 0 - 24 (first 25 items)
            if(i <= 24) {
                alpha[i] = i * i;
            // if the first if statement is not correct. Java will go to the next if or else if statement and the first will NOT be executed. If the first i bigger or equal to 25 execute this statement.
            }else if(i >= 25) {
                alpha[i] = 3 * i;
            }
            System.out.print("Index: " + i + " value: " + alpha[i] + "\n");
        }
    }
}