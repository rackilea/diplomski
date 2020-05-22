String basic = "<%" +
        " def mc1=testInstance.&test;" +
        "println \"mc1 class ${mc1.getClass()}\";" +
        "println \"mc1 metaclass ${mc1.getMetaClass()}\";" +
        "println mc1.getClass();" +
        "mc1();" +
        "mc1('var1');" +
        "mc1('var1', 'var2');" +
        "testMethod();" +
        "testMethod('var1');" +
        " %>";

TemplateEngine engine = new GStringTemplateEngine();

TestMethodClass instance = new TestMethodClass();

// Prepare binding map
Map<String, Object> bindings = new HashMap<>();
bindings.put("testInstance", instance);

Template t = engine.createTemplate(basic);

Closure<?> make = (Closure<?>) t.make(bindings); // cast as closure

int resolveStrategy = make.getResolveStrategy();
make.setResolveStrategy(Closure.OWNER_FIRST);

// set method closure which you want to invoke directly (without .
// notation). This is more or less same what you pass via binding map
// but too verbose. You can encapsulate this inside a nice static                 
// method
InvokerHelper.setProperty(
    make.getOwner(), "testMethod", new MethodClosure(instance, "test")
);

make.setResolveStrategy(resolveStrategy);
String result = make.toString();