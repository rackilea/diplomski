public Integer fitness() {
    int n = myCurrentStr.length();
    int m = target.length();
    int l = n < m ? n : m;
    int f = Math.abs(n - m) * 2; // in my code it was m - n, 
    for (int i = 0; i < l; i++) {
        if (myCurrentStr.charAt(i) != target.charAt(i))
            f = f + 1;
    }
    this.myFitness = f;
    this.isFitness = true;
    return f;
}