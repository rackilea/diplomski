public class Foo {
        private Object overRiddenJsonType;

        public Object getOverRiddenJsonType() {
            return overRiddenJsonType;
        }

        public void setOverRiddenJsonType(Object overRiddenJsonType) {
            this.overRiddenJsonType = overRiddenJsonType;
        }
    }

    public class FooConsumer {
        public void consumeFoo(Foo foo) {
            Boolean b = false;
            Bar bar = null;
            if (foo.getOverRiddenJsonType() instanceof Boolean) {
                b = (Boolean)foo.getOverRiddenJsonType();
                // worry about NPE from unboxing later...
            } else if (foo.getOverRiddenJsonType() instanceof Bar) {
                bar = (Bar)foo.getOverRiddenJsonType();
            }
            // ...
        }