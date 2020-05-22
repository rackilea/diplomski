class Tool {

    private Tool() { // Preventing direct instantiation with private constructor
        this.span = new Span();
    }

    ... // Tool class code

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Tool tool = new Tool();

        public Builder withId(String id) { 
            tool.span.addAttribute(new Attribute(Attribute.ID, id));
            return this;
        }   

        ... // other methods in the same manner

        public Tool build() {
            // Add some validation if necessary
            return tool;
        }
    }
}