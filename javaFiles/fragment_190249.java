class Test
{
    static void Main() {
        // Entirely valid
        SomeEnum.VALUE1.value = "x";
    }

    enum SomeEnum {
        VALUE1("value1");

        private String value;

        private SomeEnum(final String value) {
            this.value = value;
        }
    }
}