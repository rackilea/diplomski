public static final AtomicInteger count = new AtomicInteger();

/**
 * Implementation of the abstract base listener
 */
public static class MyListener extends JavaBaseListener {
    /**
     * Overrides the default callback called whenever the walker has entered a method declaration.
     * This raises the count every time a new method is found
     */
    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        count.incrementAndGet();
    }
}