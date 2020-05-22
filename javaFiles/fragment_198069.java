public class Test2 {
    public static void main(String[] args) throws Exception 
    {
        int[][][] my3dArray = new int[3][3][]; 
        Random r = new Random();

        for (int currentRow = 0; currentRow < my3dArray.length; currentRow++){
            for (int currentColumn = 0; currentColumn < my3dArray[currentRow].length; currentColumn++){
                my3dArray[currentRow][currentColumn] = returnZ(r.nextInt(11));
                System.out.print(my3dArray[currentRow][currentColumn][0]);
            }
            System.out.println("");
        }
        System.out.println(Arrays.deepToString(my3dArray));
    }

    public static int[] returnZ(int input)
    {
        int Z[] = new int[2];
        int value1 = input;                                 
        int value2 = 0;
        if (input%10 != 0){
            if (input%10 > 5) 
                value2 = 1;
            if (input%10 < 5) 
                value2 = 2;
        }
        else 
            value2 = 0;

        Z[0] = value1;
        Z[1] = value2;
        return Z;
    }
}