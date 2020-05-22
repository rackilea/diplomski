Below is the equivalent Java code for the above (problem) partition function written in C.The initial call to partition function,say,from inside main, may be somewhat like this:partition(arr,0,arr.length-1);
Thanks for all your support and guidance

  static void partition(int arr[],int first,int last)
    {
        int left=first;
        int right=last,temp=0;
        if(left>=right)
            return;
        Random rnd=new Random();
        int pivot = arr[left + rnd.nextInt(right - left)];
        while(left<right)
        {
            while(arr[left]<pivot)
                left++;
            while(arr[right]>pivot)
                right--;
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        partition(arr,first,left);
        partition(arr,left+1,last);

    }