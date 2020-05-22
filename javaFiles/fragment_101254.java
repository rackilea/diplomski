public Practice(int n) {
    this.n=n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++) {
            this.decay=new double[i][j];
        }
    }
}