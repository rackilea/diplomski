public int[] shiftArray(int[] arr){ 

      for(int i = 0; i < arr.length - 1; i ++) {
              if((arr[i] == 0) && (i != (arr.length - 1))){
                  int prev = arr[i];
                  int next = arr[i + 1];
                  arr[i] = next;
                  arr[i + 1] = prev;
              }
      }
    return arr;
  }