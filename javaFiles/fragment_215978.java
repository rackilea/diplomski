private void testDefaultConstructorMethod(JFieldVar uutField, JVar staticTYPEVar, final JDefinedClass unitTestClass, JDefinedClass definedClass, JCodeModel codeModel)
{
    int modifiers = JMod.PUBLIC;

    JMethod unitTestMethod = unitTestClass.method(modifiers, Void.TYPE, "testDefaultConstructor");
    unitTestMethod.annotate(org.junit.Test.class);

    JBlock unitTestBody = unitTestMethod.body();

    unitTestBody.assign(uutField, JExpr._new(unitTestClass));
    JClass abstractItemMetadataClass = definedClass._extends();

    JInvocation assertEqualsInvoke = codeModel.ref(org.junit.Assert.class).staticInvoke("assertEquals").arg(staticTYPEVar).arg(JExpr.invoke(uutField, "getType"));
    unitTestBody.add(assertEqualsInvoke);
}