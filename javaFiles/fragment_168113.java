import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ReportGUI extends JFrame {
    JPanel part1 = new JPanel();
    JPanel part2 = new JPanel();
    JPanel part3 = new JPanel();

    // !! added
    private JComboBox<String> wellbox;
    protected int well;
    protected boolean selected;
    private String[] DUMMY_DATA = { "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday" };

    public ReportGUI() {
        super("Report Card Generator");
        setLayout(new BorderLayout());
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // v.lvl = 10; add(part2, BorderLayout.CENTER); Part2();

        add(part1, BorderLayout.CENTER);
        Part1();
    }

    public void Part1() {
        JButton nextPartBtn = new JButton("Next Part");
        nextPartBtn.addActionListener(new Actions());
        part1.add(nextPartBtn);
    }

    private class Actions implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            remove(part1);
            add(part2, BorderLayout.CENTER);
            part2.setVisible(true);
            Part2();

            //!!
            revalidate();
            repaint();
        }
    }

    public void Part2() {
        /* building JPanel part2 */
        // !! wellbox = new JComboBox(v.wellskills[v.lvl]);
        wellbox = new JComboBox<>(DUMMY_DATA);
        part2.add(wellbox);
        wellbox.setLocation(75, 120);
        wellbox.setSize(650, 40);
        wellbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    well = (wellbox.getSelectedIndex() - 1);
                    System.out.println(well);
                    if (well >= 0) {
                        selected = true;
                    }
                }
            }
        });
        /* rest of building JPanel part2 */

        //!!
        JButton showPart3Btn = new JButton(new AbstractAction("Show Part 3") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                remove(part2);
                add(part3, BorderLayout.CENTER);
                part3.setVisible(true);
                Part3();
                revalidate();
                repaint();
            }
        });

        part2.add(showPart3Btn);

    }

    public void Part3() {
        /* building JPanel part3 */
        part1.removeAll();
        part2.removeAll();
        part3.removeAll();
        remove(part3);
        add(part1, BorderLayout.CENTER);
        // part1.setVisible(true);
        Part1();
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReportGUI().setVisible(true);
            }
        });
    }
}