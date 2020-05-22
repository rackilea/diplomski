class Person implements Cloneable {

        private String firstName;
        private String lastName;

        public Object clone() {

            Person obj = new Person();
            obj.setFirstName(this.firstName);
            obj.setLastName(this.lastName);

            return obj;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }