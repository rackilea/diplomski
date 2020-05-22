int arr[] = {9, 12, 4, 7, 10, 2, 5, 8, 11, 3};
int sum = 0;
for (int i: arr)
    sum += i;
int a = 0;
int left = 0, mid = 0;
int best = 0;
for (int b = 0; b < arr.length; b++)
{
    mid += arr[b];
    // since this loop increases `a` with every iteration,  and `a` never resets,
    // it will not run more than O(n) times in total
    while (a < b && Math.min(left + arr[a], mid - arr[a]) > Math.min(left, mid))
    {
        left += arr[a];
        mid -= arr[a];
        a++;
    }
    int right = sum - mid - left;
    best = Math.max(best,
                    mid + left + right - Math.max(mid, Math.max(left, right)));
}
System.out.println(best);