import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class ExampleGrid extends JPanel {
    public ExampleGrid() {

        JPanel mainGrid = new JPanel();
        mainGrid.setLayout(new GridLayout(0, 7));
        // just to show a little off-set of the days
        mainGrid.add(new JLabel());
        mainGrid.add(new JLabel());
        mainGrid.add(new JLabel());

        // now fill the calendar
        for (int i = 0; i < 30; i++) {
            mainGrid.add(new DayRectangle(i + 1));
        }

        JLabel monthLabel = new JLabel("JULY", SwingConstants.CENTER);
        monthLabel.setFont(monthLabel.getFont().deriveFont(Font.BOLD, 36f));

        // label the days of the week at the top
        String[] daysOfWk = { "Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat" };
        JPanel daysOfWkPanel = new JPanel(new GridLayout(1, 7));
        for (String dayOfWk : daysOfWk) {
            daysOfWkPanel.add(new JLabel(dayOfWk, SwingConstants.CENTER));
        }

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(monthLabel, BorderLayout.PAGE_START);
        topPanel.add(daysOfWkPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(mainGrid, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // not sure what you want to do here
    }

    private static void createAndShowGui() {
        ExampleGrid mainPanel = new ExampleGrid();

        JFrame frame = new JFrame("Example Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class DayRectangle extends JPanel {
    private static Color RECT_COLOR = Color.LIGHT_GRAY;
    private static final int PREF_W = 60;
    private static final int GAP = 4;
    private static final float FNT_SZ = 20f;
    private int day;

    public DayRectangle(int day) {
        this.day = day;

        setLayout(new GridBagLayout());

        JLabel label = new JLabel("" + day);
        label.setFont(label.getFont().deriveFont(Font.BOLD, FNT_SZ));
        add(label);

        // if you desire a background to show throw
        // setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(RECT_COLOR);
        g.fillRect(GAP, GAP, PREF_W - 2 * GAP, PREF_W - 2 * GAP);
    }

    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_W);
    }

    public int getDay() {
        return day;
    }

}