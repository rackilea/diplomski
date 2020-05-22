class Foo {

    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<Student> students = new ArrayList<Student>();
        // student = getDetails();

        // I don't have your database so I added the students manually
        students.add(new Student("Student1", "1000"));
        students.add(new Student("Student1", "1002"));
        students.add(new Student("Student1", "1003"));

        for(int i = 0; i < students.size(); i++) {
            for(int j= i+1; j < students.size(); j++) {
                if(students.get(i).getName().equals(students.get(j).getName())) {

                    // altered this line to produce expected output
                    String id = students.get(j).getId();

                    // also altered this line to produce expected output
                    students.get(i).setId(students.get(i).getId() + "," + id);

                    students.remove(j);

                    j--; // apply bandaid
                }
            }
        }

        for(Student s : students) {
            System.out.println(s.toString());
        }
    }

    private static class Student {
        private String name;
        private String id;

        public Student(String n, String i) {
            name = n;
            id = i;
        }

        public void setName(String n) {
            name = n;
        }

        public void setId(String i) {
            id = i;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String toString() {
            return name + " " + id;
        }
    }

}