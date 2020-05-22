@Aspect
public class MyAspect {

  @Pointcut("execution((@MyAnnotation *).new(..))")
   public void bla() {
   }

  @After("bla()")
   public void after(JoinPoint joinPoint) {
    try {
     joinPoint.getTarget().getClass().getDeclaredField("version").set(joinPoint.getTarget(), VersionProvider.getVersion());
    } catch (IllegalAccessException | NoSuchFieldException e) {
      e.printStackTrace();
    }
  }
}