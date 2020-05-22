public class OuterClass<T> {
    private T outerField;

    public class InnerClass {
        private T innerField;
        public void setField() {
            innerField =  outerField;
        }
    }
}