@Bean
public A a() {
    B b = new MyB();
    A a = new A(b); // new A is not possible since A is abstract but you got the idea
    return a;
}

// ...

class MyService {
   @Autowired
   A a;

   void something() {
      (a.b instanceof MyB) // true
   }

}