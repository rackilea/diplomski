class A {
    int i;
    private int j;

    void setij(int x, int y) {

        i = x;
        j = y;
    }   

    class B extends A {

        int b;
        void sum() {
           b = i + j;
        }
    }
}