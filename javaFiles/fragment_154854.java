class ExitPuzzle extends MyAbstractClass {
    public static void main(String... args) throws IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        Class clazz = MyAbstractClass.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));
        methods[0].setAccessible(true);
        methods[0].invoke(new ExitPuzzle(), null);
    }

}

abstract class MyAbstractClass {
    private void myMethod() {
        System.out.println("in MyAbstractClass");
    }
}