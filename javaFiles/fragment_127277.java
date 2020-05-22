import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeCombos extends JFrame {

    private static final int Number_OF_COMBOS = 4;
    private JButton jButton1;
    List<JComboBox> listOfComboBoxes;
    private JPanel panel;
    int counter = 0;

    MakeCombos(){

        super("Test frame");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400,300));
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //create a panel
        panel = new JPanel();
        getContentPane().add(panel);

        //add button to it
        jButton1 = new JButton("Click Me");
        //add action listener to the panel
        jButton1.addActionListener((ActionEvent e)-> {
            jButton1ActionPerformed();
        });
        panel.add(jButton1, BorderLayout.CENTER);

        validate();
        pack();
        setVisible(true);

        listOfComboBoxes = makeCombos();
    }

    /**
     *@return
     */
    private List<JComboBox> makeCombos() {

        List combos = new ArrayList<JComboBox>();

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


        listOfComboBoxes.get(counter);
        listOfComboBoxes.get(counter).addItem("--Select the Teacher--");
        getContentPane().add(listOfComboBoxes.get(counter)) ;//.setSize(a,b);

        counter++;

        pack();

    }

    public static void main(String[] args)  {

        new MakeCombos();
    }

}