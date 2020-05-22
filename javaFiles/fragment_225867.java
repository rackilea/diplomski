public class SampleSO{
    public static void main(String []args){}

    public static int[][] intArrayMethod(int[][] n){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                n[i][j] *= 2;
            }
        }
        return n;
    }
}