public class Teacher extends Person {
    private String facultyID;
    @Override
    public boolean equals(Object other) {
        //this line is nonsense, not all Persons are Teachers
        //boolean personEquals = super.equals(other);

        //avoid using try-catch
        //try {

        //verify that the other object is not null
        if (other == null) {
            return false;
        }

        //verify that the other object is specifically a Teacher, not a super or a subclass of it
        if (this.getClass().equals(other.getClass()) {
            //here comes the real check
            Teacher otherTeacher = (Teacher)other;
            return this.facultyID.equals(otherTeacher.facultyID);
        }
        return false;
    }
}