public class Test {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        X obj = new X();
        Method method = obj.getClass().getMethod("test", null);
        method.invoke(obj, null);
    }   
}

class X {
    public void test(){
        System.out.println("method call");
    }
}