public enum Strategy {

    FIRST_STRATEGY {
        public String process(String input) {
            // Implementation for first strategy
            return null;
        }       
    },

    SECOND_STRATEGY {
        public String process(String input) {
            // Implementation for second strategy
            return null;
        }       

    };

    public abstract String process(String input);

}