public enum Status {
    CLOSED(1), NEW(2), RUNNING(3), OPEN(4), ADDED(5), SUCEESS(-1), DONE(0);
        private int code;
        private Status(int code) {
        this.code = code;
    }
        public int getCode() {
        return code;
    }
        public void setCode(int code) {
        this.code = code;
    }
        public static Status valueOf(int i){
        for (Status s : values()){
            if (s.code == i){
                return s;
            }
        }
        throw new IllegalArgumentException("No matching constant for " + i);
    }