import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Pattern extends JComponent
{
    private JFrame frame;
    private JPanel panelBody;
    private JPanel panelMenu;
    private JPanel panelAll;
    private GridLayout glBody;
    private GridLayout glMenu;
    private BorderLayout bl;
    private ArrayList<JLabel> label;
    private ArrayList<JTextField> tf;
    private ArrayList<JButton> button;
    private ArrayList<JButton> buttonMenu;

    public Pattern()
    {
        label = new ArrayList<JLabel>();
        tf = new ArrayList<JTextField>();
        button = new ArrayList<JButton>();
        buttonMenu = new ArrayList<JButton>();
    }

    public void createFrame(String title)
    {
        this.frame = new JFrame(title);
        frame.setSize(1500,1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    public JFrame getFrame()
    {
        return this.frame;
    }

    public void setBorderLayout()
    {
        this.bl = new BorderLayout();
    }

    public BorderLayout getBorderLayout()
    {
        return this.bl;
    }

    public void setGridLayoutBody(int a, int b)
    {
        glBody = new GridLayout(a,b);
    }

    public void setGridLayoutMenu(int a, int b)
    {
        glMenu = new GridLayout(a,b);
    }

    public GridLayout getGridLayoutBody()
    {
        return this.glBody;
    }

    public GridLayout getGridLayoutMenu()
    {
        return this.glMenu;
    }

    public void createPanel()
    {
        this.panelAll = new JPanel();
        this.panelAll.setLayout(this.getBorderLayout());
        //this.panelAll.add(this.panelBody);
    }

    public void createPanelBody()
    {
        this.panelBody = new JPanel();
        //this.panelMenu.setLayout(this.getBorderLayout());
        this.panelBody.setLayout(this.getGridLayoutBody());
    }

    public void createPanelMenu()
    {
        this.panelMenu = new JPanel();
        //this.panelMenu.setLayout(this.getBorderLayout());
        this.panelMenu.setLayout(this.getGridLayoutMenu());
    }

    public JPanel getPanelBody()
    {
        return this.panelBody;
    }

    public JPanel getPanelMenu()
    {
        return this.panelMenu;
    }

    public JPanel getPanel()
    {
        return this.panelAll;
    }

    public void addLabel(JLabel l)
    {
        this.label.add(l);
        this.panelBody.add(l);
    }

    public ArrayList<JLabel> getLabel()
    {
        return this.label;
    }

    public void addTextField()
    {
        this.panelBody.add(new JTextField());
    }

    public ArrayList<JTextField> getTF()
    {
        return this.tf;
    }

    public void addButton(JButton b)
    {
        this.button.add(b);
        this.panelBody.add(b);
    }

    public void addButtonMenu(JButton b)
    {
        this.buttonMenu.add(b);
        this.panelMenu.add(b);
    }

    public ArrayList<JButton> getButton()
    {
        return this.button;
    }

    public void createMenu()
    {
        this.createPanelMenu();
        this.setGridLayoutMenu(16,1);
        this.panelMenu.setLayout(this.getGridLayoutMenu());
        this.addButtonMenu(new JButton("K-Nearest Table Classifier"));
        this.addButtonMenu(new JButton("Heaviside"));
        this.addButtonMenu(new JButton("Forward Pass"));
        this.addButtonMenu(new JButton("Backward Pass"));
        this.addButtonMenu(new JButton("Naive"));
    }

    public void addToPanel()
    {
        this.panelAll.add("West", this.panelMenu);
        this.panelAll.add("North", this.panelBody);
    }

}

class MainPattern
{
    public static void main(String[] args)
    {
        Pattern knear = new Pattern();

        knear.createFrame("K-Nearest Clasifier");

        knear.setBorderLayout();

        knear.setGridLayoutBody(2,2);

        knear.createPanel();

        knear.createPanelBody();

        knear.createMenu();

        knear.addLabel(new JLabel("K = "));

        knear.addTextField();

        knear.addButton(new JButton("Calculate!"));

        knear.addButton(new JButton("Reset!"));

        knear.addToPanel();

        knear.getFrame().setContentPane(knear.getPanel());
        knear.getFrame().invalidate();
        knear.getFrame().repaint();
    }
}