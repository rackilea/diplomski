public static void main(String[] args) {
    int x = 24; 
    WhyAPrints0 set = new WhyAPrints0();
    set.setWhy(x);
    WhyAPrints01 get = new WhyAPrints01(set);
    get.print();
}