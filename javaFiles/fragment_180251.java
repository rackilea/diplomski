public class College
{
    private ArrayList<Faculty> faculty;

    public College()
    {
        faculty = new ArrayList<Faculty>();
    }

    public void addFaculty(Faculty f)
    {
        faculty.add(f);
    }

    public void fireFaculty(Faculty f)
    {
        faculty.remove(f);
    }
}