public class ClassA {

    @Inject
    private ApplicationContext appContext;

    private ClassB classB;

    //Bean will be instanciated when this method is called
    public ClassB getClassB() { 
        if (classB == null) {
            classB = appContext.getBean(ClassB.class);
        }
        return classB;
    }
}