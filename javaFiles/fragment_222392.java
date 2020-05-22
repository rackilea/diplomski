class Animals implements CharSequence {

        public int id;
        public String type, vertebrate, aclass;

public Animals(int id,String type,String vertebrate,String aclass) {
this.id = id;
this.type = type;
this.vertebrate = vertebrate;
            this.aclass = aclass;
        }

        public int getID() {
            return id;
        }

        public String getType() {
            return type;
        }

        public String getVert() {
            return vertebrate;
        }

        public String getaclass() {
            return aclass;
        }

        @Override
        public int length() {
            return toString().length();
        }

        @Override
        public char charAt(int index) {
            return toString().charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return toString().subSequence(start, end);
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Animals [id=" + id + ", type=" + type + ", vertebrate=" + vertebrate + ", aclass=" + aclass + "]";
        }


        }