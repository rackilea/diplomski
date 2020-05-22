@Configuration // Mark the Main class as the class where Spring will find its configuration
@ComponentScan // Ask Spring to look for other components within the Main class package
@EnableAspectJAutoProxy // Let Spring auto configure AspectJ aspects for us...
public class Main {

    private static int subClassCounter;

    public static void main(String[] args) {
        subClassCounter=0;

        GenericApplicationContext  context = new AnnotationConfigApplicationContext(Main.class);

        SubClassN sbc1 = context.getBean(SubClassN.class);
        SubClassN sbc2 = context.getBean(SubClassN.class);
        SubClassN sbc3 = context.getBean(SubClassN.class);

        ChangeExistingCode cec = context.getBean(ChangeExistingCode.class);

        // Let subClass instances run normally...
        cec.setActive(true);
        letThemDoSomething("BEFORE", sbc1, sbc2, sbc3);

        // Now change existing scenario...
        cec.setActive(false);
        letThemDoSomething("AFTER", sbc1, sbc2, sbc3);

        context.close();
    }

    private static void letThemDoSomething(String prefix, SubClassN... existingClasses) {
        System.out.format("%s ======\n", prefix);
        for (SubClassN subClassInstance : existingClasses) {
            subClassInstance.doSomething();
        }
        System.out.println();
    }

    @Bean // Tell Spring to use this method for creating SubClassN instances
    @Scope(BeanDefinition.SCOPE_PROTOTYPE) // Scope prototype force creation of multiple instances
    private static SubClassN buildSubClassN() {
        subClassCounter++;
        return new SubClassN(subClassCounter);
    }
}