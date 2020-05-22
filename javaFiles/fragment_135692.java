@Pointcut("execution(* org.practice.entity.Person.*())")
     private void methodCall() {}

@Before("!getter() && methodCall")
    public void noGetter() {
        System.out.println("NO GETTER GETS CALLED");
    }