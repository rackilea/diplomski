public boolean groupNoAdj(int start, int[] nums, int target) {

        if (start >= nums.length) {return (target == 0);}  //neded to change to '>=' because start can go over length of array 

//in your code you return true when the two following numbers from array are chosen, which is contrary to the requirement of the task 
        if (groupNoAdj(start + 2, nums, target - nums[start])){ 
            return true;
        }

        if (groupNoAdj(start + 1, nums, target)){
            return true;
        } 

        return false;
    }