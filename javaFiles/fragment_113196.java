public class Student implements Comparable<Student> {

    String name;
    int age;

    public Student(String name, int age) {
       this.name = name;
       this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }

    @Override
    public int compareTo(Student o) {
        return Comparators.NAME.compare(this, o);
    }


    public static class Comparators {

        public static Comparator<Student> NAME = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        public static Comparator<Student> AGE = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        };
        public static Comparator<Student> NAMEANDAGE = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i = o1.name.compareTo(o2.name);
                if (i == 0) {
                    i = o1.age - o2.age;
                }
                return i;
            }
        };
    }
}