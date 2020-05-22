import java.util.List;

public class StudentsReturnTypesTest
{
    public static void main(String[] args)
    {
        B bObject = getBObject();
        List<Student> studentList = bObject.getColleges();

        D dObject = getDObject();
        List<SeniorStudent> seniorStudentList = dObject.getColleges();        
    }

    private static D getDObject() { return null; }
    private static B getBObject() { return null; }
}

interface A<T extends Student> {
    public Student isCurrentStudent(String name);
    public List<T> getStudentList();
}

interface AS extends A<Student> { }

interface B extends AS {
    public List<Student> getColleges();
}

interface C extends A<SeniorStudent> {
    public SeniorStudent isCurrentStudent(String name);
    public List<SeniorStudent> getStudentList();
    public void addStudent(Attributes s);
}

interface D extends C /* B Not possible, see below */  {
    public List<SeniorStudent> getColleges();
}

interface Attributes {}
interface Student {}
interface SeniorStudent extends Student {}