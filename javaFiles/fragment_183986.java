static boolean tracked = false;

@Pointcut("if()")
public static boolean tracked() {
  return tracked;
}

@Before("execution(*  testMaven.testing.aa(..)) && tracked()")
public void testBefore(){
    System.out.println("yooi");
}

@Before("execution(*  testMaven.testing.setDd(..)) && tracked() ")
public void testBefore2(){
    System.out.println("yooi2");
}