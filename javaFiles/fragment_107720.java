static int sqrRoot(int n){
    //Find largest square <= n
    int sqr = 0;

    for (int i=15; i >= 0; --i){
        int newsqr = sqr + (1<<i);
        if (newsqr * newsqr <= n) {sqr = newsqr;}
    }

    return sqr;
}

static int[] closestFactors(int n){
    if (n <= 0) {throw new IllegalArgumentException();}

    int s = sqrRoot(n);
    if (s*s == n){
        int[] ans = {s,s};
        return ans;
    }

    int a = s * s - n;      
    while(s < n){
        if (a > 0){ //may not be true on first iteration
            int sa = sqrRoot(a);
            //whole number case
            if (sa*sa == a){    //We found a factorization
                int[] ans = {s-sa, s+sa};
                return ans;
            }
        }

        //half number case
        int sa2 = sqrRoot(a+s);
        if (sa2 * (sa2+1) == a+s){
            int[] ans = {s-sa2, s+sa2+1};
            return ans;
        }

        a += s + s + 1;
        s++;
    }

    int[] ans = {1, n};
    return ans;
}