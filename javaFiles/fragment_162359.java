public class GUI extends JFrame {

    //...//

    public GUI(Database DB) {...}

    public void setStudent(LinkedList<Student> students) {
        StudentTable.setModel(new StudentTableModel(students));
    }
}