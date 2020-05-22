import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElasticPanel
{
    private JFrame frame;
    private JPanel contentPane;
    private JPanel basePanel;
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
                    basePanel.remove(prodCombo[i]); 
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
                basePanel.add(prodCombo[counter - 1]);  
                System.out.println("Item Added\nCounter : " + counter);
            }

            //basePanel.revalidate();
            //basePanel.repaint();
            frame.pack();
        }
    };

    public ElasticPanel()
    {
        prodCombo = new JComboBox[1];
        counter = 1;
    }

    private void displayGUI()
    {
        frame = new JFrame("Elastic Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();

        basePanel = new JPanel(new GridLayout(0, 1, 5, 5));

        prodCombo[counter - 1] = new JComboBox(data);
        prodCombo[counter - 1].setActionCommand("" + (counter - 1));
        prodCombo[counter - 1].addActionListener(comboAction);

        basePanel.add(prodCombo[counter - 1]);
        contentPane.add(basePanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ElasticPanel().displayGUI();
            }
        });
    }
}