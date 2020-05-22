import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameForm {

    private JFrame theFrame;
    private JPanel BoardPanel;
    private PlayerPanel p1Panel;
    private PlayerPanel p2Panel;

    public static void main(String[] args) {
        new GameForm();
    }

    public GameForm()
    {
        //set up the Frame
        theFrame = new JFrame();
        //set up the board panel
        BoardPanel = new JPanel(new BorderLayout());
        BoardPanel.setBackground(Color.BLUE);
        theFrame.add(this.BoardPanel);
        //set up the first players board
        p1Panel = new PlayerPanel();
        p1Panel.setBackground(Color.RED);
        this.BoardPanel.add(p1Panel);

        theFrame.setSize(new Dimension(800,500));
        theFrame.setVisible(true);
        theFrame.setResizable(false);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class PlayerPanel extends JPanel {

    private java.util.List<PositionButton> ButtonList;

    public PlayerPanel()
    {

        ButtonList = new ArrayList<PositionButton>();
        for(int i = 0;i < 10;i++)
            for(int j = 0;j < 10;j++)
            {
                PositionButton pb = new PositionButton(i,j);
                ButtonList.add(pb);
                add(pb);
            }
    }
}

class PositionButton extends JButton {

    private int x;
    private int y;

    public PositionButton(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.setVisible(true);
    }


    public int getXCoord()
    {
        return this.x;
    }

    public int getYCoord()
    {
        return this.y;
    }
}