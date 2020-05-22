public interface MyLibrary extends Library {
    MyLibrary INSTANCE = (MyLibrary)Native.loadLibrary("mylib", MyLibrary.class);

    class MyStruct extends Structure {
        public static class ByValue extends MyStruct implements Structure.ByValue {}
        public int i;
        public double a[3];
        protected List getFieldOrder() {
            return Arrays.asList("i", "a");
        }
    }

    void mysub(MyStruct.ByValue arg);
}