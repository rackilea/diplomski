@Aspect
public class DayOfWeekAspect {

    public DayOfWeekAspect() {
    }

    @Around("execution(* *(..)) && args(session,..) && @annotation(edu.berkeley.jazztwo.aspect.ams.roles.DayOfWeek)")
    public Object dayOfWeek(ProceedingJoinPoint joinPoint, HttpSession session) throws Throwable {

        String[] names = this.getNames(this.getAnnotatedMethod(joinPoint));

        for (String name : names) {
            System.out.println("DayOfWeek:   " + name);
        }

        // Do whatever you want with the aspect parameters
        if (checkSomething(names)) {
            // in some cases, go to a different view/controller
            return new ModelAndView(...);
        }

        // Just proceed into the annotated method
        return joinPoint.proceed();
    }

    private Method getAnnotatedMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod();
    }

    private String[] getNames(Method method) {
        DayOfWeek aspect = method.getAnnotation(DayOfWeek.class);
        if (aspect != null) {
            return aspect.names();
        }
        return new String[0]; // no annotation, return an empty array
    }
}