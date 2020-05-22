public static class Something {

        private Object value;
        private int type;

        /**
         * Constructor of Something class
         *
         * @param value
         * @param type type 0 String <br/>
         * type 1 Integer <br/>
         * type 2 float ....
         */
        public Something(Object value, int type) {
            this.value = value;
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

    }