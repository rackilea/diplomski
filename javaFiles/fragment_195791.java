class JavaTest2 extends JavaTest {
    int i = 10;
    void add(int i) {
        System.out.println(5+i);
        System.out.println(5+this.i); //this will add 5 to i attribute in JavaTest2
        System.out.println(5+super.i); //this will add 5 to i attribute in JavaTest
    }
}