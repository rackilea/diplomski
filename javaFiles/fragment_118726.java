public class Main {

    // main method setting up and printing students
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        Student s1 = new Student();
        s1.setScore(90);
        s1.setFirstName("abc");
        students.add(s1);

        Student s2 = new Student();
        s2.setScore(95);
        s2.setFirstName("def");
        students.add(s2);

        Student s3 = new Student();
        s3.setScore(85);
        s3.setFirstName("xyz");
        students.add(s1);
        System.out.printf("Unordered: %s%n", students);
        // sorting using anonymous Comparator
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                // notice the cast to (Integer) to invoke compareTo
                return ((Integer)s1.getScore()).compareTo(s2.getScore());
            }
        });
        System.out.printf("Ordered: %s%n", students);
    }
    // Student class
    static class Student {
        private int score;
        private String firstName;
        // boring stuff
        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String name) {
            this.firstName = name;
        }
        // for printing
        @Override
        public String toString() {
            return String.format("Student \"%s\" with score: %d%n", firstName,
                    score);
        }
    }
}