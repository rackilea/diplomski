int len = 1;
int last = nums[0];
int count = 1;
for (int i = 1; i < nums.length; i++) {
    int x = nums[i];
    if (x != last) {
        nums[len++] = x;
        last = x;
        count = 1;
    } else if (count < 2 || x == 0 && count < 3) {
        nums[len++] = x;
        count++;
    }
}
// use len instead of nums.length from this point on