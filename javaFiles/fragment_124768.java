import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameControler {

    private Model model;
    private View view;

    public GameControler() {

        model = new Model();
        view = new View(model);
        view.getButton().addActionListener(e-> movePlayer());
    }

    //move player to a random position for demo purpose only 
    private void movePlayer() {
        final Random rnd = new Random();
        model.setPlayerX(rnd.nextInt(100));//arbitrary limit which maybe outside bounds
        model.setPlayerY(rnd.nextInt(100));//arbitrary limit which maybe outside bounds
        view.refresh();
    }

    public static void main(String[] args) {
        new GameControler();
    }
}

class View {

    private final static int GAP = 2;
    Model model;
    private MainPanel mainPanel;

    View(Model model){
        this.model = model;
        createAndShowGUI();
    }

    void refresh() {
        mainPanel.repaint();
    }

    private void createAndShowGUI() {
        JFrame f = new JFrame("Single Player Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new MainPanel();
        f.add(mainPanel);
        f.pack();
        f.setVisible(true);
    }

    JButton getButton() {   return mainPanel.getButton();   }

    class MainPanel extends JPanel {

        private BottomPanel bPanel;

        MainPanel() {
            setLayout(new BorderLayout(GAP,GAP));
            add(new TopPanel(), BorderLayout.PAGE_START);
            add(new BoardPanel(), BorderLayout.CENTER);
            bPanel = new BottomPanel();
            add(bPanel, BorderLayout.PAGE_END);
        }

        JButton getButton() {   return bPanel.getButton();  }
    }

    class TopPanel extends JPanel {
        TopPanel() {
            setLayout(new FlowLayout(FlowLayout.LEADING));
            add(new JLabel("This is the game board "));
        }
    }

    class BoardPanel extends JPanel {

        Player player;

        BoardPanel()   {

            setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
            GridLayout layout = new GridLayout(model.getBoardRows(), 
            model.getBoardCols());
            setLayout(layout);

            for (int i = 0; i <model.getBoardRows(); i++)   {

                for (int j = 0; j < model.getBoardCols(); j++)  {
                    add(new Tile());
                }
            }

            player = new Player();
            player.setBounds(new Rectangle(100,100, 100, 100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            player.paint(g);
        }
    }

    class Tile extends JLabel {

        Tile() {
            setPreferredSize(new Dimension(model.getSquareSize(), model.getSquareSize()));
            setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
        }
    }

    class Player extends JLabel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(model.getPlayerX(), model.getPlayerY(), model.getPlayerSize(),model.getPlayerSize());
        }
    }

    class BottomPanel extends JPanel {

        JButton button = new JButton("Move Player");

        BottomPanel(){
            add(button);
        }

        JButton getButton() {   return button;  }
    }
}

class Model{

    private int boardRows = 3, boardCols = 5, squareSize = 50;
    private int playerX = 0, playerY = 0, playerSize =15;

    int getPlayerX() {  return playerX; }

    void setPlayerX(int playerX) {  this.playerX = playerX; }

    int getPlayerY() {return playerY;   }

    void setPlayerY(int playerY) {  this.playerY = playerY; }

    int getPlayerSize() {return playerSize; }

    int getBoardRows() {return boardRows; }

    int getBoardCols() {return boardCols; }

    int getSquareSize() {return squareSize; }
}