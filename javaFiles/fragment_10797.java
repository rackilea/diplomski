void print3elementSubsets(int[] s) {
    int n = s.length;
    for(int i = 0; i < n-2; i++) {
        for(int j = i+1; j < n-1; j++) {
            for(int k = j+1 ; k < n; k++) {
                print("{"+s[i]+ ", "+s[j]+"," +s[k]+"}");
            }
        }
    } 
}