public class Test
{
    public static void main(String[] args) throws Exception { 
        Test test = new Test();
        Child child = new Child();

        // Your approach, which doesn't work
        try {
            test.getClass().getMethod("doSomething", new Class[] { child.getClass() });

        } catch (NoSuchMethodException ex) {
            System.out.println("This doesn't work");
        }

        // A working approach
        for (Method method : test.getClass().getMethods()) {
            if ("doSomething".equals(method.getName())) {
                if (method.getParameterTypes()[0].isAssignableFrom(child.getClass())) {
                    method.invoke(test, child);
                }
            }
        }
        System.out.println("This works");

    }

    public void doSomething(Parent parent) {

    }
}

class Parent {

}

class Child extends Parent {

}