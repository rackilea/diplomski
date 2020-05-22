boolean isEverywhere(int[] nums, int val) {    

        // use i+=2 to get start index of pair.
        for(int i=0;i<nums.length;i+=2) {

                // other index in the pair.
                int j = i + 1;

                // make sure the other index really exists.
                if(j < nums.length) { 

                        // if it exists..and val is not equal to 
                        // either in the pair..return false.
                        if(nums[i] != val && nums[j] != val) {
                                return false;
                        }       
                } else {
                        // no pair..one element case.
                        // return true if that element is val..else return false.
                        return nums[i] == val; 
                }       
        }

        // array has no unpaired element..and all pairs have val.
        return true;     
}