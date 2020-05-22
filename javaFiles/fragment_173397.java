@Autowired
public A(@Lazy B b) {
    System.out.println("A.A() - 1-param Constructor");
    System.out.println(b.toString());
    this.b = b;
}