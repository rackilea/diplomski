public boolean groupNoAdj(int start, int[] nums, int target) {
        if(target - nums[start] == 0) // there is no need let 'start' be greater than the lenghth of nums' array 
            return true;

  //doing what in the previous code but I am not letting to call function with start greater than the length of nums' array
        if (!(start + 2 >= nums.length) && groupNoAdj(start + 2, nums, target - nums[start])){
            return true;
        } 

        if (!(start + 1 == nums.length) && groupNoAdj(start + 1, nums, target)){
            return true;
        }

        return false;
    }