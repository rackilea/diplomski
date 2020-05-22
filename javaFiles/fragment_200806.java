class Foo {

    private int a = 2;
    public int b = 3;

    public void test(int a,int b){
        this.b = b;
        this.a = a; // accessing private field a
    }

    public static void main(String args[]){
        Foo x = new Foo();
        x.test(1,2);
    }
}