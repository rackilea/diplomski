package stackoverflow.test;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SchoolPanel extends AbstractJPanel implements SchoolFields {

    private static final long serialVersionUID = -6201476099194804075L;

    private JTextField schoolNameField = null;
    private JTextField gradeField = null;
    private JCheckBox honorsCheckBox = null;
    private JLabel schoolNameLabel = null;
    private JLabel gradeLabel = null;
    private JLabel honorsLabel = null;

    public SchoolPanel() {
        super();


        schoolNameLabel = new JLabel("School Name: ");
        gradeLabel = new JLabel("Grade: ");
        honorsLabel = new JLabel("Is Honors: ");

        schoolNameField = new JTextField();
        gradeField = new JTextField();
        honorsCheckBox = new JCheckBox();

        add(schoolNameLabel);
        add(schoolNameField);
        add(gradeLabel);
        add(gradeField);
        add(honorsLabel);
        add(honorsCheckBox);
    }

    @Override
    public void setSchoolName(String schoolName) {
        schoolNameField.setText(schoolName);
    }

    @Override
    public void setGrade(int grade) {
        gradeField.setText(""+grade);
    }

    @Override
    public void setHonorsProgram(boolean isHonors) {
        honorsCheckBox.setSelected(isHonors);
    }

    @Override
    public String getSchoolName() {
        return schoolNameField.getText();
    }

    @Override
    public int getGrade() {
        return Integer.parseInt(gradeField.getText());
    }

    @Override
    public boolean hasHonorsProgram() {
        return honorsCheckBox.isSelected();
    }
}