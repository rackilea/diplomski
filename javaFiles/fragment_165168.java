JCodeModel codeModel = new JCodeModel();
JDefinedClass myValueClass = codeModel._class(JMod.PUBLIC, "MyValue", ClassType.CLASS);
JDefinedClass containerClass = codeModel._class(JMod.PUBLIC, "Container", ClassType.CLASS);
JDefinedClass annotationClass = containerClass._annotationTypeDeclaration("MyAnnotation");
JMethod method = annotationClass.method(JMod.NONE, myValueClass.array(), "myValues");
method.declareDefaultValue(new JExpressionImpl(){
    @Override
    public void generate(JFormatter f) {
        f.p("{}");
    }
});