public class Test {
    public static void main(String[] args){
        boolean[][] ret = new boolean[5][5];
        for(boolean[] arr : ret){
            Arrays.fill(arr, true);
        }

        for(boolean[] arr : ret){
            System.out.println(Arrays.toString(arr));
        }
    }
}