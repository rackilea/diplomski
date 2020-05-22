int firstBurst = jobs[0][2];
jobs[0][2] = Integer.MIN_VALUE;
Arrays.sort(jobs, new Comparator<int[]>(){
    public int compare(int[] a, int[] b) {
        // don't use subtraction, this can lead to underflows
        return a[2] < b[2] ? -1 : (a[2] == b[2] ? 0 : 1);
    }
});
jobs[0][2] = firstBurst;