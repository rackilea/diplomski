@Aspect
@Transactional
@Component
public class FilterProjectsAspect {

@Pointcut("execution(*  com.xxx.ProjectRepository.findAll(..))")
    public void projectFindAll() {
    }

    @Around("projectFindAll()")
    public Object  filterProjectsByUser(final ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Predicate) {
                Predicate predicate=(Predicate) args[i];
                BooleanExpression isProjectOwner =buildExpressionForUser()
                predicate = ExpressionUtils.allOf(isProjectOwner, predicate);
                args[i]=predicate;  //Update args
            }
        return pjp.proceed(args);
    }

}