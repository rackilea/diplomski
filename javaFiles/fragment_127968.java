public static int[] seperator(int[] arr1, int left, int right){
    int temp;
    if(left>=right)       
      return arr1; 
    else if(arr1[left]%2==0 && arr1[right]%2!=0){
      temp=arr1[left];
      arr1[left]=arr1[right];
      arr1[right]=temp;   
      return seperator(arr1, left+1, right-1);
    }
    else{
      if(arr1[right]%2==0){//if right side is on even #, then decrease index
        return seperator(arr1, left, right-1);
      }
      if(arr1[left]%2!=0){//if left side is on odd #, then increase index
        return seperator(arr1, left+1, right);
      }
    } 
    return arr1;
  }