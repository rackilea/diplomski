@XStreamAlias("parent")
    @XStreamConverter(value = ParentConverter.class)
    public class Parent {
        private final String message;

        public Parent(final String message) { this.message = message; }
        public String getMessage() { return message; }
    }