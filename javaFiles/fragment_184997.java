@Aspect
@Component
public class MyAspect {

    /**
     *
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositories() {
    }

    /**
     * @param joinPoint
     */
    @Before("repositories()")
    public void setDatabase(JoinPoint joinPoint) {
       Object target = joinPoint.getTarget();

       // find the "MyBean" field
       Field myBeanField = Arrays.stream(target.getClass().getDeclaredFields())
            .filter(predicate -> predicate.getType().equals(MyBean.class)).findFirst().orElseGet(null);

       if (myBeanField != null) {
           myBeanField.setAccessible(true);
           try {
              MyBean bean = (MyBean) myBeanField.get(target);// do stuff
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
    }

}