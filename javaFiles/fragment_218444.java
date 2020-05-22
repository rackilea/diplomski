private static int partition(int[] arr,int left,int right) {
        int pivot = arr[right];
        int small = left-1;
        for(int k = left;k < right;k++)
        {
            if(arr[right] <= pivot)
            {
                small++;
                swap(arr,right,small);            
            }


        }
        swap(arr,right,small+1);
        System.out.println("Pivot= "+arr[small+1]);//prints out every sort
        System.out.println(Arrays.toString(arr));
        return small+1;


    }

    private static void swap(int[] arr, int k, int small) {//easy swap method
        int temp;
        temp = arr[k];
        arr[k] = arr[small];
        arr[small] = temp;

    }