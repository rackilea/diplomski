private static class Test {
    private int test = 10;
}

public static void main(String[] args) throws Exception {
    final Test test = new Test();
    final Field field = Test.class.getDeclaredField("test");
    field.setAccessible(true);
    final int value = field.getInt(test);
    System.out.println(value);
}