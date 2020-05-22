public class A {
    public String text;
    public String moreText;
    public class B {
        public B(String text) {
            A.this.text = text;
        }
        public int i;
        public A getA() {
            return A.this;
        }
    }
}
A.B b = new A.B("Hello");
System.out.println(b.getA().text); // Hello