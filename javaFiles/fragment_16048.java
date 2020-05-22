import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FramePanel extends JPanel
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FramePanel framePanel = new FramePanel();
        f.getContentPane().add(framePanel);

        f.setSize(600,600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private final List<List<Vehicle>> list = new LinkedList<List<Vehicle>>();

    /**
      Constructs the panel.
     */
    public FramePanel()
    {  
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                addCarAt(e.getX(), e.getY());
            }
        });
    }

    private void addCarAt(int x, int y)
    {
        Car car = new Car(x, y); 
        List<Vehicle> temp = new LinkedList<Vehicle>();
        temp.add(car); //Add Vehicle to LinkedList
        list.add(temp); //Add LinkedList to Collection of LinkedLists
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr) 
    {
        super.paintComponent(gr) ;
        Graphics2D g = (Graphics2D)gr;

        for (List<Vehicle> veh : list) // list is collection of Linked Lists
        { 
            for (Vehicle v : veh)
            {
                v.draw(g);
            }  
        }
    }
}