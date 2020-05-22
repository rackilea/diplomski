for (int i = 0; i < nums.length-1; i++){
      if(nums[i] == 0){ // if current element is 0
           int largestOddNumber = Integer.MIN_VALUE; // temp largest odd number
           boolean oddNumberExists = false; // is there an odd number to the right of the 0
           for (int j = i + 1; j < nums.length; j++){
               if(nums[j] % 2 != 0){ // is it an odd number
                  largestOddNumber = Math.max(largestOddNumber, nums[j]); // get largest odd number
                   oddNumberExists = true; // there exists an odd number
               }
           }
           if (oddNumberExists) nums[i] = largestOddNumber; // if odd number exists then replace 0 with the largest odd number
      }
}
return nums; //return modified array;