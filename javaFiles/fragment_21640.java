public class test_arr {
    public double[] getValues(int n){
        double[] anArray = new double[n];
        for(int i =0; i <n;i++)
            anArray[i] = Math.random();
        return anArray;
    }
}