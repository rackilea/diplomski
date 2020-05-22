Arrays.sort(jobs, 1, jobs.length, new Comparator<int[]>(){
    public int compare(int[] a, int[] b) {
        // don't use subtraction, this can lead to underflows
        return a[2] < b[2] ? -1 : (a[2] == b[2] ? 0 : 1);
    }
});