private int[] reverse(int[] nums) {
   int[] rtn = new int[nums.length];
   for (int pos = 0; pos < nums.length; pos++) {
      rtn[nums.length - pos - 1] = nums[pos];
   }
   return rtn;
}

private boolean contains(int[] nums, int[] segment) {
   for (int i = 0; i <= nums.length - segment.length; i++) {
      boolean matches = true;
      for (int j = 0; j < segment.length; j++) {
         if (nums[i + j] != segment[j]) {
            matches = false;
            break;
         }
      }
      if (matches) return true;
   }
   return false;
}