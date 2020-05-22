public static void mergeSort(int[] array, int left,  int lHigh, int right, int rHigh) {   
        // what do lHigh and rHigh represent?

        int elements = (rHigh - lHigh +1) ;     
        int[] temp = new int[elements];
        int num = left;

      // what does this while loop do **conceptually**? 
      while ((left <= lHigh) && (right <= rHigh)){
       if (a[left] <= a[right]) {
          // where is 'pos' declared or defined?
          temp[pos] = a[left];
          // where is leftLow declared or defined? Did you mean 'left' instead?
          leftLow ++;
        }
        else {
          temp[num] = a[right];
          right ++;
        }
       num++;   
      }

     // what does this while loop do **conceptually**?
     while (left <= right){
        // At this point, what is the value of 'num'?
        temp[num] = a[left];
        left += 1;
        num += 1;   
     }
     while (right <= rHigh) {
        temp[num] = a[right];
        right += 1;
        num += 1;       
     }
     // Maybe you meant a[i] = temp[i]?
     for (int i=0; i < elements; i++){
       // what happens if rHigh is less than elements at this point? Could
       // rHigh ever become negative? This would be a runtime error if it did
       a[rHigh] = temp[rHigh];
       rHigh -= 1;      
     }