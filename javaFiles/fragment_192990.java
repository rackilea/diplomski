/*
    T extends from DemoInterface1, okay - this is myClass1 
       |
       |             the generic parameter of that 
       |             DemoInterface1 is bound to T, 
       |             which as mentioned, 
       |             extends from DemoInterface1 
       |             (in your case, it means this is myClass1<Integer>, NOT Integer)
       |                         |
       |                         |
       |                         |
       |                         |          here you receive a bound for T
       |                         |          where T is meant to extend from
       |                         |             DemoInterface1<T>
       |                         |          in your example, T is myClass1<Integer>, and NOT `Integer` that is the <T> of DemoInterface1<T> (myClass1<Integer>)
       |                         |              
       |                         |               |
      \|/                       \|/             \|/         */
static <T extends DemoInterface1<T>> void myFunc(T t) {
    t.display(t);
}