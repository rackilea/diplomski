public class Player {
        private String firstName;
        private String lastName;
        private int age; 

        public Player(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String firstName() {
            return firstName;
        }

        public String lastName() {
            return lastName;
        }

        public String age() {
            return age;
        }

    }