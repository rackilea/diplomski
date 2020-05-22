import java.lang.reflect.*;

class Person {
    private String name = "default";

    public String getName() {
        return name;
    }

    // Obviously this would normally take a parameter
    public void setName() {
        name = "name has been set";
    }
}

class Test {

    private Person person = new Person();

    public Person getPerson() {
        return person;
    }

    // Note that we're only declaring throws Exception for convenience
    // here - diagnostic code only, *not* production code!
    public void callMethods(String... methodNames) throws Exception {
        Object res = this;
        for (String methodName : methodNames) {
            Method method = res.getClass().getMethod(methodName);
            res = method.invoke(res);
        }
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.callMethods("getPerson", "setName");
        System.out.println(test.getPerson().getName());
    }
}