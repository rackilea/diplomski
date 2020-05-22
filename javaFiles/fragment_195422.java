import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboTest {

    private JLabel imageLabel;
    private JComboBox comboImage;

    private String[] names = {"", "ukIcon","caIcon","unknwon"};
    private boolean flag;
    private int counter;
    private String previousValue;

    public ComboTest(){
        flag = false;
        counter = 0;
        previousValue = "";
        initComponents();
    }

    public void initComponents(){
        JFrame frame = new JFrame("Test Combo");        
        frame.setSize(320, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        comboImage = new JComboBox(names);
        comboImage.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent event){
                if(event.getStateChange() == ItemEvent.SELECTED){
                    if (flag)
                        comboImage.setSelectedItem(previousValue);
                    else
                    {
                        counter++;
                        if (counter == 3)
                            flag = true;
                        previousValue = (String) comboImage.getSelectedItem();  
                        System.out.println((String) comboImage.getSelectedItem());
                    }   
                }
            }
        });

        frame.add(comboImage);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ComboTest();
            }
        });
    }
}