public class Teacher {

    private String teacherNo;
    ...
    private List<Course> courses;

    public List<Course> getCourses() {
       if ( courses == null)
          courses = new ArrayList<Course>();
       return courses;
    }
}