class Test {
    public  void print(Integer object) {
        System.out.println("object");
    }

    public  void print(Number string) {
        System.out.println("String");
    }
}
new Test().print(null);