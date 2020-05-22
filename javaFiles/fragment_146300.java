import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class CharTable extends JPanel{
    private static final int DIM_WIDTH = 500;
    private static final int DIM_HEIGHT = 500;

    Object[][] charTable = {{'a', 'b', 'c'},{'d', 'e','f'}};
    String[] colNames = {"col1", "col2", "col3"};

    public CharTable(){
        add(new JScrollPane(new JTable(charTable, colNames)));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
    }

    public static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.add(new CharTable());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    public Dimension getPreferredSize(){
        return new Dimension(DIM_WIDTH, DIM_HEIGHT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGui();
            }
        });
    }
}