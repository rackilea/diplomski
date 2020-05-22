import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeCombos extends JFrame {

    private static final int Number_OF_COMBOS = 4;
    private List<JComboBox<String>> listOfComboBoxes;

    private JPanel combosPanel;

    private int xPosition = 28;
    private int yPosition = 100;
    private int width = 145;
    private int height = 28;
    private     int counter = 0;

    MakeCombos(){

        //make width frame for testing
        super("Test frame");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,400));
        setLocationRelativeTo(null);
        //set layout manager to the frame
        getContentPane().setLayout(new BorderLayout());

        //add panel + button to the frame
        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.NORTH); //add the panel to the frame

        //add button to the button panel
        JButton jButton1 = new JButton("Click Me");
        //add action listener to the button
        jButton1.addActionListener((ActionEvent e)-> {
            jButton1ActionPerformed();
        });
        buttonPanel.add(jButton1, BorderLayout.CENTER);

        //--add width panel for the combos
        combosPanel = new JPanel();
        //set layout manager to null so you can layout each combo
        //consider using a layout manager instead 
        combosPanel.setLayout(null); 
        getContentPane().add(combosPanel, BorderLayout.CENTER); //add the panel to the frame

        validate();
        pack();
        setVisible(true);

        //make the combos and add them to width list
        listOfComboBoxes = makeCombos();
    }

    /**
     *
     */
    private List<JComboBox<String>> makeCombos() {

        List<JComboBox<String>> combos = new ArrayList<JComboBox<String>> ();

        for(int i = 0;  i < Number_OF_COMBOS; i++) {

            JComboBox<String> combo = new JComboBox<>(new String[] {});
            combos.add(combo);
        }
        return combos;
    }

    private void jButton1ActionPerformed() {

        if(counter >= listOfComboBoxes.size()) {
            return;
        }

        //////////////////////////////////////////////////////////////////////////////
        //////////////// note : all this block could be moved to MakeCombos() ////////
        // (adding content and setting bounds could have been done when creating ////
        //the combo

        //add content to the combo
        listOfComboBoxes.get(counter).addItem("--Select the Teacher--");

        //set layout bounds to each combo
        listOfComboBoxes.get(counter).setBounds(xPosition, yPosition, width, height);

        //increment position
        xPosition=xPosition+30;
        yPosition=yPosition+40;

        ////////////////////////////////////////////////////////////////////////////
        /////////////////////// end of move-to-makeCombos() block //////////////////
        ////////////////////////////////////////////////////////////////////////////

        //add the combo to the combos panel
        combosPanel.add(listOfComboBoxes.get(counter)) ;

        //increment position and counter
        counter++;

        repaint();
        pack();

    }

    public static void main(String[] args)  {

        new MakeCombos();
    }
}