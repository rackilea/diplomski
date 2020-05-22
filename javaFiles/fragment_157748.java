public String subArrayProblem_LinearTime(int[] a, int[]b) {
    int aIndex = 0;
    int bIndex = 0;
    while (bIndex < b.length && aIndex < a.length) {
        int value = b[bIndex];
        int value2 = a[aIndex];
        if(value != value2) {
            aIndex++;
        }
        else {
            aIndex++;//we can do this since the elements are distinct. If duplicates are possible, don't advance aIndex here.
            bIndex++;
        }
    }
    return bIndex == b.length;//did every index in b find a match before we ran out of aIndex?
}