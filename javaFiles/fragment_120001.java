import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Example extends JPanel {

    private TLabel[][] grid;

    List<TLabel> redCels = new ArrayList<>();
    List<TLabel> blueCells  = new ArrayList<>();
    List<List<TLabel>> paths = new ArrayList<>();

    Example(int rows, int cols) {

        setLayout(new GridLayout(rows, cols, 1, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.BLACK);
        createGrid(rows, cols);
        setTestData();
    }

    void createGrid(int rows, int cols) {

        grid = new TLabel[rows][cols];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new TLabel(Token.VIDE);
                grid[r][c].setOpaque(true);
                grid[r][c].setBackground(Color.WHITE);
                add(grid[r][c]);
            }
        }
    }

    void setTestData() {

        //test data
        set(11, 3, Token.CERCLE_ROUGE);
        set(10, 2, Token.CERCLE_ROUGE);
        set(9, 3, Token.CERCLE_ROUGE);
        set(10, 4, Token.CERCLE_ROUGE);

        set(8, 13, Token.CERCLE_BLEU);
        set(9, 12, Token.CERCLE_BLEU);
        set(10, 13, Token.CERCLE_BLEU);
        set(9, 14, Token.CERCLE_BLEU);

        paths.add(redCels); paths.add(blueCells);
    }

    void set(int row, int col, Token token) {

        grid[row][col].setToken(token);

        if(token == Token.CERCLE_ROUGE) {
            redCels.add(grid[row][col]);
        }else {
            blueCells.add(grid[row][col]);
        }
    }

    private List<List<TLabel>> getPahs() {
        return paths;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("TEST CASE");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Example example = new Example(20, 20);
                frame.add(example);
                DrawLines glassPane = new DrawLines(example.getPahs());
                frame.setGlassPane(glassPane);
                frame.getGlassPane().setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }


}

enum Token {

    VIDE (Color.WHITE), CERCLE_BLEU (Color.BLUE), CERCLE_ROUGE(Color.RED);

    private static final int ICON_W = 21;
    public Color color;
    public Icon icon;

    Token(Color color) {

        this.color = color;
        icon = createIcon(color);
    }

    private Icon createIcon(Color color) {

        BufferedImage img = new BufferedImage(ICON_W, ICON_W, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(color);
        g2.fillOval(1, 1, ICON_W - 2, ICON_W - 2);
        g2.dispose();

        return new ImageIcon(img);
    }
}

class TLabel extends JLabel{

    Token token;
    TLabel(Token token) {
        setToken(token);
    }

    void setToken(Token token) {

        this.token = token;
        setIcon(token.icon);
        setPreferredSize(new Dimension(
                token.icon.getIconWidth(), token.icon.getIconHeight()));
    }
    Token getToken() {
        return token;
    }

    Color getColor() {
        return token.color;
    }
}

//used as glass pane to draw lines
class DrawLines extends JPanel {

    private List<List<TLabel>> lines;
    DrawLines(List<List<TLabel>> lines) {

        this.lines = lines;
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(3));

        for(List<TLabel> line : lines) {

            //use color information from TLabel
            //the whole path is of the same color so do it one per path
            g2d.setColor(line.get(0).getColor());

            for(int i=0; i <(line.size()) ; i++) {
                TLabel label1 = line.get(i);
                int n = (i == (line.size()-1)) ? 0: i+1;
                TLabel label2 = line.get(n);
                g2d.draw(new Line2D.Float(getCenter(label1), getCenter(label2)));
            }
        }

        g2d.dispose();
    }