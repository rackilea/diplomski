public class CodeGenerator {

    public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Foo foobar = new Foo();

        Bar bar = new Bar();
        bar.setSomeValue(555d);
        foobar.setBar(bar);
        foobar.setPrimitiveDouble(23);
        foobar.setValue("Hello World!");

        CodeGenerator codeGenerator = new CodeGenerator();

        String generatedCode = codeGenerator.generateCode(foobar);

        System.out.println(generatedCode);

    }

    int counter = 0;

    private String createVariableName(String clazzName) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, clazzName + getCurrentCounter());
    }

    public String generateCode(AST ast, List statements, Object object) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String clazzName = object.getClass().getSimpleName();
        String variableName = createVariableName(clazzName);

        VariableDeclarationFragment newVariable = ast.newVariableDeclarationFragment();
        newVariable.setName(ast.newSimpleName(variableName)); // Or clazzName.toCamelCase()

        ClassInstanceCreation newInstance = ast.newClassInstanceCreation();
        newInstance.setType(ast.newSimpleType(ast.newSimpleName(clazzName)));
        newVariable.setInitializer(newInstance);

        VariableDeclarationStatement newObjectStatement = ast.newVariableDeclarationStatement(newVariable);
        newObjectStatement.setType(ast.newSimpleType(ast.newSimpleName(clazzName)));

        statements.add(newObjectStatement);

        BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
        for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
            String propertyName = propertyDesc.getName();

            if (!shouldIgnore(propertyName)) {

                MethodInvocation setterInvocation = ast.newMethodInvocation();

                SimpleName setterName = ast.newSimpleName(propertyDesc.getWriteMethod().getName());
                setterInvocation.setName(setterName);

                Object invoked = propertyDesc.getReadMethod().invoke(object);

                if (invoked == null) {
                    continue;
                }

                if (Primitives.isWrapperType(invoked.getClass())) {
                    if (Number.class.isAssignableFrom(invoked.getClass())) {
                        setterInvocation.arguments().add(ast.newNumberLiteral(invoked.toString()));
                    }

                    // TODO: Booleans
                } else {

                    if (invoked instanceof String) {
                        StringLiteral newStringLiteral = ast.newStringLiteral();
                        newStringLiteral.setLiteralValue(invoked.toString());
                        setterInvocation.arguments().add(newStringLiteral);
                    } else {

                        String newObjectVariable = generateCode(ast, statements, invoked);
                        SimpleName newSimpleName = ast.newSimpleName(newObjectVariable);
                        setterInvocation.arguments().add(newSimpleName);
                    }

                }

                SimpleName newSimpleName = ast.newSimpleName(variableName);
                setterInvocation.setExpression(newSimpleName);

                ExpressionStatement setterStatement = ast.newExpressionStatement(setterInvocation);

                statements.add(setterStatement);

            }

        }

        return variableName;
    }

    public String generateCode(Object object) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        resetCounter();

        AST ast = AST.newAST(AST.JLS3);
        Block block = ast.newBlock();

        generateCode(ast, block.statements(), object);

        return block.toString();

    }

    private int getCurrentCounter() {
        return counter++;
    }

    private void resetCounter() {
        counter = 0;
    }

    private boolean shouldIgnore(String propertyName) {
        return "class".equals(propertyName);
    }
}