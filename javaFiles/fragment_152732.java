public static int peak1D(int[] arr, int start, int end){
          //edge cases
        if (end-start==1){
            if (start==0)
                return start;
            else 
             return end;
        }
        int i = start+end>>>1;
        if (arr[i]<arr[i-1])
           return peak1D(arr,start,i);
        if (arr[i]<arr[i+1]){
            return peak1D(arr, i, end);
        }
        else
            return i;
    }