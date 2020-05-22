public int quickFind (int[] nums, int lo, int hi) {
    if (lo >= hi)
        return -1;

    int gard = nums[lo];
    int i = lo + 1, j = hi + 1;

    while (true) { // *** Loop 1

        while (nums[++i] < gard) { // *** Loop 2
            if (i == hi) {
                System.out.println("break   " + i + " / " + hi + " ->" + (i == hi));
                break; // *** Breaks loop 2
            }
        }

        while (gard < nums[--j]) { // *** Loop 3
            if (j == lo)
                break; // *** Breaks loop 3
        }

        if (i > j)
            break; // *** Breaks loop 1

        if (nums[i] == gard)
            return nums[i];
        if (nums[j] == gard) 
            return nums[j];

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    nums[lo] = nums[j];
    nums[j] = gard;

    return 1 + quickFind(nums, lo, j - 1) + quickFind(nums, j + 1, hi);
}