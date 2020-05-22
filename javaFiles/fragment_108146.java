private void init(int i, int j, int k){
    this.i = i;
    this.j = j;
    this.k = k;
    category = Category.fromInts(i,j,k);
}

enum Category {
        MMM, MMP, MPM, MPP, PMM, PMP, PPM, PPP, 
        OMM, OMP, OPM, OPP, MOM, MOP, POM, POP, 
        MMO, MPO, PMO, PPO, MOO, POO, OMO, OPO, 
        OOM, OOP, OOO;

        static Category fromInts(int i, int j, int k){
            return Category.valueOf( (i<0?"M":(i==0?"O":"P"))
                                    +(j<0?"M":(j==0?"O":"P"))
                                    +(k<0?"M":(k==0?"O":"P")));
        };
}