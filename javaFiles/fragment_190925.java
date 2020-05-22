class Foo {

    public enum MyEnum {
        MyEnumType, MyEnumType2;

        public String bar() {
            return MY_STRING;
        }

        public String bar2() {
            return MY_STRING + "2";
        }

        private static final String MY_STRING = "a string I reuse in the enum";
    }
}