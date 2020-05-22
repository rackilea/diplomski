public class GroupOfStudents{
    // Creates a new Vector when an instance is created
    public Vector<Student> vectorOfStudents = new Vector<Student>(); 
    public GroupOfStudents(Vector<Student> vectorOfStudents) {
        // Throws away the Vector created above and uses the one from the parameter instead
        this.vectorOfStudents = vectorOfStudents;
    }
}