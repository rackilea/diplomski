// This function calculates n-choose-k
public static int nchoosek(int n, int k){
    if(k == 1){
        return n;
    }else{
            // To come up with this, you need to write down your equation and try
            // to express n-choose-k as a function of n-1-choose-k-1
        return nchoosek(n - 1, k - 1) * n / k;
    }
}