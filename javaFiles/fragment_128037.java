public class College
{
    Student s = new Student();
    ArrayList <Student> entries;

    public College()
    {
        entries = new ArrayList<Student>();
    }

    public void add(Student s)
    {
        entries.add(s);
    }
}