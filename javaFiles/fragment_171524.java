import java.util.List;

class Attributes {}
class Student { }

interface A {
    Student isCurrentStudent(String name);
    List<? extends Student> getStudentList();
}

interface B extends A {
    List<? extends Student> getColleges();
}


class SeniorStudent extends Student{ }

interface C extends A {

    @Override
    SeniorStudent isCurrentStudent(String name);

    @Override
    List<SeniorStudent> getStudentList();

    void addStudent(Attributes s);
}

interface D extends B,C {
    @Override
    List<SeniorStudent> getColleges();
}
public class CovariantList
{
    public static void main(String[] args)
    {
        B b = null;
        List<? extends Student> collegesB = b.getColleges();

        D d = null;
        List<SeniorStudent> collegesD = d.getColleges();
    }
}