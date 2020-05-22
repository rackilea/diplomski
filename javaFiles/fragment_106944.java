public class Test {

    public enum TestEnum {
        FIRST, SECOND, THIRD
    }

    public Test(Class<? extends Enum> enumType) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        Enum[] values = (Enum[]) enumType.getDeclaredMethod("values").invoke(
            null);
        System.out.println(Arrays.toString(values));
    }

    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Test t = new Test(Test.TestEnum.class);
    }
}


>> [FIRST, SECOND, THIRD]