import java.util.*;

class TestStudent
{
    public static void main(String args[])
    {
        List<Student> StudentList= new ArrayList<Student>();
        Student tempStudent = new Student();
        tempStudent.setName("Rey");
        tempStudent.setIdNum(619);
        StudentList.add(tempStudent);
        System.out.println(StudentList.get(0).getName()+", "+StudentList.get(0).getId());
    }
}

class Student
{
    private String fname;
    private int stId;

    public String getName()
    {
        return this.fname;
    }

    public int getId()
    {
        return this.stId;
    }

    public boolean setName(String name)
    {
        this.fname = name;
        return true;
    }

    public boolean setIdNum(int id)
    {
        this.stId = id;
        return true;
    }
}