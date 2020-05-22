public class Main {

    public static void main(String[] args) {
        Student_Testing.test();
    }
}

public class Student_Testing {

    public static void test(){
        Student student1 = new Student();
        Student student2 = new Student("Joe", 123);
        int id = student1.getStudentID();
        String name = student1.getName();
        System.out.println("ID 1: " + id);
        System.out.println("Name 1: " + name);
        int id2 = student2.getStudentID();
        String name2 = student2.getName();
        System.out.println("ID 2: " + id2);
        System.out.println("Name 2: " + name2);
    }
}

public class Student {
    //student class stuff...
}