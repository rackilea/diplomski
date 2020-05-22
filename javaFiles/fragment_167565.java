import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class CourseCon extends JPanel {

    private static JPanel editPanel;
    private JComboBox<String> editComboLevel;
    private JComboBox editCombo;
    private static ArrayList<Course> course = new ArrayList<Course>();

    public CourseCon() {

        editPanel = new JPanel();
        editPanel.setPreferredSize(new Dimension(100, 70));
        editPanel.add(editCombo = new JComboBox(course.toArray(new Course[course.size()])));
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        editCombo.setRenderer(renderer);
        editCombo.setSelectedIndex(0);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Example of Code Snippet");
        JComponent newContentPane = new CourseCon();
        newContentPane.setOpaque(true);
        frame.add(editPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(120, 80));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                course.add(new Course("Course-1", "Description-1",
                        1, 2, "Level 1"));
                course.add(new Course("Course-2", "Description-2",
                        3, 4, "Level 2"));
                createAndShowGUI();
                for (Course item : course) {
                    System.out.println(item);
                }
            }
        });
    }

    class ComboBoxRenderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            if (value instanceof Course) {
                Course course = (Course) value;
                value = course.getCourseNum();
            }

            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }

    public static class Course {

        private String courseNum, courseTitle, courseLevel;
        private int courseDur, courseFee;

        Course() {
        }

        Course(String courseNum, String courseTitle, int courseDur,
                int courseFee, String courseLevel) {
            this.courseNum = courseNum;
            this.courseTitle = courseTitle;
            this.courseDur = courseDur;
            this.courseFee = courseFee;
            this.courseLevel = courseLevel;
        }

        @Override
        public String toString() {
            String courseInfo = this.getCourseNum() + ", " + this.getCourseTitle() + ", "
                    + this.getCourseDur() + ", " + this.getCourseFee() + ", " + this.getCourseLevel();
            return courseInfo;
        }

        public String getCourseNum() {
            return this.courseNum;
        }

        public String getCourseTitle() {
            return this.courseTitle;
        }

        public int getCourseDur() {
            return this.courseDur;
        }

        public int getCourseFee() {
            return this.courseFee;
        }

        public String getCourseLevel() {
            return this.courseLevel;
        }

        public void setCourseNum(String courseNum) {
            this.courseNum = courseNum;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

        public void setCourseDur(int courseDur) {
            this.courseDur = courseDur;
        }

        public void setCourseTitle(int courseFee) {
            this.courseFee = courseFee;
        }

        public void setCourseLevel(String courseLevel) {
            this.courseLevel = courseLevel;
        }
    }
}