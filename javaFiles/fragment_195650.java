public static void quickSort(Integer[] nums, int left, int right) {
    final int pivot = nums[(left + right) / 2]; // <== Fix pivot value.
    int l = left;
    int r = right;
    while (l <= r) {
        while (nums[l] > pivot) {
            l++;
        }
        while (nums[r] < pivot) {
            r--;
        }
        if (l <= r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
    if (left < r) {
        quickSort(nums, left, r);
    }
    if (l < right) {
        quickSort(nums, l, right);
    }
}