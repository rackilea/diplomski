public enum Test {
    TEST1(String.class),
    TEST2(Object.class),
    ;

    Class clazz;

    Test(Class<?> clazz) {
        this.clazz = clazz;
    }

    <T> T getInstance() throws IllegalAccessException, InstantiationException {
        return (T)clazz.newInstance();
    }

    public static void main(String[] args) {
        try {
            String str = TEST1.getInstance();
            Object obj = TEST2.getInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}