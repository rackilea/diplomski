int[] minimums = new int[] {5, 50, ...};
int[] upperRanges = new int[] {100, 200, ...};
int[] values = new int[minimums.length];
int result = 0;
for (int i = 0; i < minimums.length; i++) {
    values[i] = Random(0, upperRanges[i]); // still pseudo code
    result += values[i];
    if (values[i] <= minimums[i])
        break;
}
// result is the cumulative sum
// If you don't reference values later, then you can replace it with a regular int to be used again and again.