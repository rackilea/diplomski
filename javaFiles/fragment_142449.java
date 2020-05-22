@Bean('Client1.myService')
public MyService getMyService1() {
    return new MyService1();
}

@Bean('Client2.myService')
public MyService getMyService2() {
    return new MyService2();
}