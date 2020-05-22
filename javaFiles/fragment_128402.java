Chess(int m, int n) {
    this.m = m;
    this.n = n;
    //if statement to check if NULL or both set to zero
    //{
        //TODO:  Check to make sure no NULLs or Zero values
    //}
    setPreferredSize(new Dimension(WIDTH,HEIGHT));
    setVisible(true);
    setLayout(new GridLayout(m,n));
    pack();
}