public enum InformationType {
    MESSAGE {
        @Override 
        public String displayInfo() {
            ....
        }
    },
    FAQ {
        @Override 
        public String displayInfo() {
            ....
        }
    },
    :
    :
    LAST_TYPE {
        @Override
        public String displayInfo() {
            ....
        }
    };

    abstract public String displayInfo();
}