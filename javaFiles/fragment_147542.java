public enum Animal {

    COW {
        public String talk() {
            return "moo";
        }
    },
    FROG {
        public String talk() {
            return "croak";
        }
    };

    public abstract String talk();
}