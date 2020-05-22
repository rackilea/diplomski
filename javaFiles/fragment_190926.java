public class Foo {
    public static enum MyEnum {
        MyEnumType(0, MY_STRING), MyEnumType2(1, "Hello");

        private int ordinal;
        private String value;

        MyEnum(int ordinal, String value) {
            this.ordinal = ordinal;
            this.value = value;
        }

        public int getOrdinal() {
            return ordinal;
        }

        public String getValue() {
            return value;
        }

        public void setOrdinal(int ordinal) {
            this.ordinal = ordinal;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private static final String MY_STRING = "a string I reuse in the enum";
}