@SuppressWarnings("unused")
@Aspect
public class UserInputSanitizerAdivsor {

    @Around("execution(@RequestMapping * * (..))")
    public Object check(final ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                Object o = args[i];
                if (o != null && o instanceof String) {
                    String s = (String) o;
                    args[i] = UserInputSanitizer.sanitize(s);
                }
            }
        }
        return jp.proceed(args);
    }
}