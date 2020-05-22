public class Test {

    public static class Index
    {
        int x;
        int y;
    }
    public static <T> T get(T[][] array, Index i)
    {
        return array[i.x][i.y];
    }
    public static void main(String[] args)
    {
        Index ix = new Index();
        ix.x = 1;
        ix.y = 2;

        Integer[][] arr = new Integer[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                arr[i][j] = 3*i + j;

        System.out.println(get(arr,ix));
    }
}