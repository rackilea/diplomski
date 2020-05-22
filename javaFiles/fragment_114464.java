public void scaleMult(int k) {
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            this.neo[i][j] *= k;
            // you forgot to assign the value, basically we multiply neo[i][j] by k and make neo[i][j] receive that value
            // making this.neo[i][j] = this.neo[i][j] *k; would work as well
        }
    }
}//scaleMult