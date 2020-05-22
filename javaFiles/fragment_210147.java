Calculate obj1=new Calculate();
Calculate obj2=new Calculate() {
    int operation(int a, int b){
        return Math.min(a,b);
    }
};

obj1.operation(a,b) // calculates maximum
obj2.operation(a,b) // calculates minimum