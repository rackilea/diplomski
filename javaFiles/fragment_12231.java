import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {
        Course course1 = new Course("course 1", "teacher 1");
        Course course2 = new Course("course 2", "teacher 2");
        Course course3 = new Course("course 3", "teacher 3");
        Course course4 = new Course("course 4", "teacher 4");
        Student student1 = new Student("name 1", "15", Arrays.asList(course1, course2, course3, course4));
        Student student2 = new Student("name 2", "16", new ArrayList<>());
        Student student3 = new Student("name 2", "16", Arrays.asList(course1, course3));
        Student student4 = new Student("name 4", "17", new ArrayList<>());

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

    List<Objects> objects = students.stream().flatMap(student -> 
        student.getCourses().isEmpty() ?
            Stream.of(new Objects(student.getName(), student.getAge(), null, null)) :
            student.getCourses().stream().map(course -> new Objects(student.getName(), student.getAge(), course.getCourseName(), course.getTeacher()))
    ).collect(Collectors.toList());

        objects.forEach(System.out::println);
    }
}

class Course {
    String courseName;
    String teacher;

    public Course(String courseName, String teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}

class Student {
    String name;
    String age;
    List<Course> courses;

    public Student(String name, String age, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

class Objects{
    String name;
    String age;
    String courseName;
    String teacher;

    public Objects(String name, String age, String courseName, String teacher) {
        this.name = name;
        this.age = age;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "name: " + this.name + " age: " + this.age + " course name: " + this.getCourseName() + " teacher: " + this.getTeacher();
    }
}