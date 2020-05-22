public class CDIUtils {

    public static BeanManager beanManager() {
        try {
            return (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            throw new IllegalStateException("Unable to obtain CDI BeanManager", e);
        }
    }

    public static void makeManagedStatic(Object obj) {
        BeanManager bm = beanManager();
        makeManaged(obj, bm);
    }

    public static void makeManaged(Object obj, BeanManager beanManager) {
        Class objClass = (Class) obj.getClass();
        AnnotatedType annotatedType = beanManager.createAnnotatedType(objClass);
        InjectionTarget injectionTarget = beanManager.createInjectionTarget(annotatedType);
        CreationalContext context = beanManager.createCreationalContext(null);
        injectionTarget.inject(obj, context);
    }

}