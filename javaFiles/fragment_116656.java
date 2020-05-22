public static int[] BBSort(int arr[],int n) {
    int K,tmp;

    long Data_comp=0,Data_move=0;

    K = n;
    while(K!=0)
    {
        for (int i = 0; i < K-1; i++) {

            if(arr[i]>arr[i+1])
            {
               tmp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = tmp;
               Data_move++;
            }
            Data_comp++;
        }

        K--;
    }
    DC = Data_comp;
    DM = Data_move;
  return arr;
}