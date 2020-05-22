import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Example {

     public void outerMethod() {

        class InnerClass {

            private double d = 7.62;

            @Override
            public String toString() {
                return String.format("[%s] d = %f", this.getClass().getName(), d);
            }

        }

    }

    public void testMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        final Class<?> clazz = Class.forName("Example$1InnerClass");
        final Constructor<?> constructor = clazz.getDeclaredConstructor(Example.class);
        constructor.setAccessible(true);
        final Object instance = constructor.newInstance(this);

        System.out.println(instance);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
         Example instance = new Example();
         instance.testMethod();
    }

}