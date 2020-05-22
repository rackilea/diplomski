import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

public class VirtualViewGUI extends JFrame
{
    private JPanel rightPanel;
    private ElasticPanel elasticPanel;

    public VirtualViewGUI()
    {
        super("Virtual View");

        JMenuBar jmenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenu feel = new JMenu("Look & Feel");

        JMenu layOutMenu = new JMenu("ConfigureCells");
        JMenuItem add_files = new JMenuItem("Select Directory.."); 
        JMenuItem minCellSize = new JMenuItem("height 260 X  width 260"); 
        JMenuItem moderateCellSize = new JMenuItem("height 320 X  width 320"); 
        JMenuItem maxCellSize = new JMenuItem("height 360 X  width 360"); 
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem help = new JMenuItem("Help Content");

        fileMenu.add(add_files);
        fileMenu.add(exit);
        layOutMenu.add(minCellSize);
        layOutMenu.add(moderateCellSize);
        layOutMenu.add(maxCellSize);
        helpMenu.add(help);

        jmenuBar.add(fileMenu);
        jmenuBar.add(layOutMenu);
        jmenuBar.add(helpMenu);

        ImageIcon myImage = null;
        try
        {
            myImage = new ImageIcon(
                new URL("http://gagandeepbali.uk.to/" + 
                        "gaganisonline/images/swing/" + 
                        "stackoverflow/cow-cartoon.jpg"));
        }
        catch(MalformedURLException mue)    
        {
            mue.printStackTrace();
        }

        JLabel icon = new JLabel(myImage);
        icon.setIcon(myImage);
        setJMenuBar(jmenuBar); 

        rightPanel = new JPanel();
        elasticPanel = new ElasticPanel(this);
        rightPanel.add(elasticPanel);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        contentPane.add(icon, BorderLayout.CENTER);
        contentPane.add(rightPanel, BorderLayout.LINE_END);

        setContentPane(contentPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);    
        setVisible(true);
        System.out.println("File Separator is : " + System.getProperty("file.separator"));
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new VirtualViewGUI();
            }
        });
    }
}

class ElasticPanel extends JPanel
{
    private JFrame frame;
    private JPanel contentPane;
    /*
     * Array to hold the JComboBox
     * elements.
     */
    private JComboBox[] prodCombo;  
    private JComboBox[] temp;
    /* 
     * Counter to keep track
     * of the number of JComboBox 
     * present.
     */
    private int counter;  
    /*
     * Data for each JComboBox
     */
    private String[] data = {
                                "None",
                                "Sub Category"
                            };

    private ActionListener comboAction =
            new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            JComboBox cbox = (JComboBox) ae.getSource();
            String command = (String) ae.getActionCommand();
            int index = Integer.parseInt(command);
            String selection = (String) cbox.getSelectedItem();

            if (selection.equals("None"))
            {
                /*
                 * i = index + 1, because, we want to
                 * remove all JComboBox after this one.
                 */
                for (int i = (index + 1); i < prodCombo.length; i++)
                {
                    temp = new JComboBox[prodCombo.length];
                    for (int j = 0; j < prodCombo.length; j++)
                        temp[j] = prodCombo[j];
                    remove(prodCombo[i]);   
                }
                prodCombo = new JComboBox[index + 1];
                for (int i = 0; i <= index; i++)
                {                   
                    prodCombo[i] = temp[i];
                }
                counter = prodCombo.length;
                System.out.println("Item Removed\nCounter : " + counter);
            }
            else if (selection.equals("Sub Category"))
            {
                counter++;
                temp = new JComboBox[counter];
                for (int i = 0; i < prodCombo.length; i++)
                {
                    temp[i] = prodCombo[i];
                }
                temp[counter - 1] = new JComboBox(data);
                temp[counter - 1].setActionCommand("" + (counter - 1));
                temp[counter - 1].addActionListener(this);
                prodCombo = new JComboBox[counter];
                for (int i = 0; i < counter; i++)
                    prodCombo[i] = temp[i];
                add(prodCombo[counter - 1]);    
                System.out.println("Item Added\nCounter : " + counter);
            }

            //revalidate();
            //repaint();
            frame.pack();
        }
    };

    public ElasticPanel(JFrame frame)
    {
        this.frame = frame;
        prodCombo = new JComboBox[1];
        counter = 1;

        setLayout(new GridLayout(0, 1, 5, 5));

        prodCombo[counter - 1] = new JComboBox(data);
        prodCombo[counter - 1].setActionCommand("" + (counter - 1));
        prodCombo[counter - 1].addActionListener(comboAction);

        add(prodCombo[counter - 1]);        
    }
}