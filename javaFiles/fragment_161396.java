public int maxMirror(int[] nums) {
   for (int window = nums.length; window > 0; window--) {
      for (int pos = 0; pos <= nums.length - window; pos++) {

         int[] segment = new int[window];
         for (int innerpos = 0; innerpos < window; innerpos++) {
            segment[innerpos] = nums[pos + innerpos];
         }

         segment = reverse(segment);
         if (contains(nums, segment)) {
            return window;
         }
      }
   }
   return 0;
}