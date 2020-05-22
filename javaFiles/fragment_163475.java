public class permutation {

    static int limit;
    public static void permutate(int arr[],int curPos)
    {
        int i;
        if(curPos==arr.length)
        {
            for(i=0;i<arr.length;i++)
            {
                System.out.print(arr[i] + "\t");
            }
            System.out.println("");
            return;
        }

        for(i=1;i<=limit;i++)
        {
            arr[curPos]=i;
            permutate(arr,curPos+1);
        }  

    }


    public static void main(String[] args) {
        int arr[] = new int[3];
        limit = 5;
        permutate(arr,0);
    }

}