public static void main(String[] args) throws ParseException {

    A a = new AImpl();
    B b = new BImpl();
    C c = new CImpl();

    Manager m1 = new Manager(a);
    Manager m2 = new Manager(b);
    Manager m3 = new Manager(c);

    m1.doSomething();
    m2.doSomething();
    m3.doSomething();

}