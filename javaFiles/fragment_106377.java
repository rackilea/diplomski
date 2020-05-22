@Override
    public int compareTo(Cust1 b) {
        if(this.a + this.s < b.a + b.s) {
            return 1;
        } else if (this.a + this.s > b.a + b.s) {
            return -1; 
        } else {
            return 0;
        }
    }