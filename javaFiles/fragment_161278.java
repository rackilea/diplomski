import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Grade2{
public static void main(String[] args) {
Runnable runnable = new Runnable() {
    @Override
    public void run() {

        JFrame frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradePanel2 panel = new GradePanel2();
        frame.add(panel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
};
    SwingUtilities.invokeLater(runnable);
}}