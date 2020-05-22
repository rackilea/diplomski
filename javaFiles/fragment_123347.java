public enum Numbers {
    ONE, TWO, THREE;
}
public void test(String[] args) throws Exception {
    Class<? extends Enum<?>> enumClass = Numbers.class;
    System.out.println(enumClass);
}