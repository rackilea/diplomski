import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ExerciseDemo extends JPanel {
    private static final int PREF_W = 500;
    private static final int PREF_H = 450;
    protected static final int MAX_COUNTER = 30;
    private JPanel exerciseHolder = new JPanel(new GridLayout(0, 1));

    public ExerciseDemo() {
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(exerciseHolder, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(scrollPane);

        new Timer(300, new ActionListener() {
            int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                exerciseHolder.add(new ExerciseList2(new Exercise("John Smith " + counter)));
                exerciseHolder.revalidate();
                exerciseHolder.repaint();
                if (counter > MAX_COUNTER) {
                    ((Timer) e.getSource()).stop();
                }
            }
        }).start();

    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        ExerciseDemo mainPanel = new ExerciseDemo();

        JFrame frame = new JFrame("ExerciseDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class ExerciseList2 extends JPanel {
    private static final Font NAME_FONT = new Font("Tahoma", Font.PLAIN, 18);
    private Exercise exercise;

    public ExerciseList2(Exercise exercise) {
        this.exercise = exercise;

        JLabel lblName = new JLabel(exercise.getName());
        lblName.setFont(NAME_FONT);

        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setLayout(new BorderLayout(15, 0));
        add(new JCheckBox("Check Box"), BorderLayout.LINE_START);
        add(lblName, BorderLayout.CENTER);
        add(new JButton("Button"), BorderLayout.LINE_END);
    }    

    public Exercise getExercise() {
        return exercise;
    }

}