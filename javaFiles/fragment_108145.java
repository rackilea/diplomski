public void init(int i, int j, int k) {
    this.i = i;
    this.j = j;
    this.k = k;
    category=Category.valueOf( (i<0?"M":(i==0?"O":"P"))
                              +(j<0?"M":(j==0?"O":"P"))
                              +(k<0?"M":(k==0?"O":"P")));
}