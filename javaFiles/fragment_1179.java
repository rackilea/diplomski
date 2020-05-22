class Base {
    public void someMethod() {
        // this stuff does the non-null behaviour
    }

    public static Base nullVersion() {
        return new NullOfBase();
    }

    private static class NullOfBase extends Base {
        @Override
        public void someMethod() {
           // this guy does the null version.
        }
    }
}