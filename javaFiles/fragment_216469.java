class StudentDetails extends JFrame 
{
    public StudentDetails(int studentID)
    {
        // "Select * from student where student_id =" + studentID;
        super();
        add(new JLabel("Detail of student with id " + studentID + " goes here"));
        setVisible(true);
        setSize(100, 100);

    }
}