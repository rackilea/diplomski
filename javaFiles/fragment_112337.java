int permute(int[] arr, int[] rankings, int i, int n) {
    int j;
    int ans = 0;
    bool isAns = false;
    if (i == n)
        System.out.println(Arrays.toString(arr));
    else {
        for (j = i; j <= n; j++) {
            swap(arr, i, j);
            isAns = check(arr, rankings);
            if(isAns){
                **here you would call your distance check on the two arrays, 
    which I am still unsure of what you actually are doing here**
                ans = *some distance calc*;
                return ans;
            }
            ans = permute(arr,rankings, i + 1, n);
            if (ans == 0){
                swap(arr, i, j); // backtrack
                isAns = check(arr, rankings);
                if(isAns){
                    **here you would call your distance check on the two arrays, 
        which I am still unsure of what you actually are doing here**
                    ans = *some distance calc*;
                    return ans;
                }
        }
    }
    return ans;
}