import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class comboBoxProblem  extends JFrame{

static JPanel myPanel  = new JPanel();
static String pat_order;
public static void main(String [] args)
    {
        new comboBoxProblem().show(); 

    }
public comboBoxProblem()
    {
        setTitle("Combo");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        myPanel.setLayout(new GridBagLayout());
        myPanel.setBorder(BorderFactory.createTitledBorder("Button's"));

        final JComboBox jc = new JComboBox(); 
        jc.addItem("ARR");
        jc.addItem("SRR");

        gbc.gridx = 0;
        gbc.gridy = 1;
        jc.addItemListener(new ItemListener() 
            {
                public void itemStateChanged(ItemEvent ie)
                    {
                        String order = (String) jc.getSelectedItem();
                        pat_order = order;
                        JOptionPane.showConfirmDialog(null, pat_order, " Message Dialog Box", JOptionPane.DEFAULT_OPTION    );
                    }
            });

        myPanel.add(jc, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;

        getContentPane().add(myPanel, gbc);



pack();
 } 

 }