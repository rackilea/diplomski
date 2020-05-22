public class PostConstructListener implements TypeListener{

    private static Logger logger = Logger.getLogger(PostConstructListener.class);

    @Override
    public <I> void hear(TypeLiteral<I> iTypeLiteral,final TypeEncounter<I> iTypeEncounter) {

        Class<? super I> type = iTypeLiteral.getRawType();

        ReflectionUtils.MethodFilter mf = new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                return method.isAnnotationPresent(PostConstruct.class);
            }
        };

        ReflectionUtils.MethodCallback mc = new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                if (!(method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0))
                {
                    logger.warn("Only VOID methods having 0 parameters are supported by the PostConstruct annotation!" +
                            "method " + method.getName() + " skipped!");
                    return;

                }
                iTypeEncounter.register(new PostConstructInvoker<I>(method));
            }
        };

        ReflectionUtils.doWithMethods(type,mc,mf);
    }

    class PostConstructInvoker<I> implements InjectionListener<I>{

        private Method method;

        public PostConstructInvoker(Method method) {
            this.method = method;
        }

        @Override
        public void afterInjection(I o) {
            try {
                method.invoke(o);
            } catch (Throwable e) {
                logger.error(e);
            }
        }
    }
}