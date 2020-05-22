import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComboIssue extends JFrame
{
    private JRadioButton rOne, rTwo;
    private ButtonGroup group;

    private JComboBox combo;

    private JLabel label;

    public ComboIssue()
    {
        rOne = new JRadioButton("One");
        rOne.addActionListener(new ROneAction());
        rTwo = new JRadioButton("Two");
        rTwo.addActionListener(new RTwoAction());
        group = new ButtonGroup();
        group.add(rOne);
        group.add(rTwo);

        combo = new JComboBox();
        combo.addItem("No Values");
        combo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
        public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
        }
        public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            jComboBox1PopupMenuWillBecomeInvisible(evt);
        }
        public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
        }
    });

        label = new JLabel("labellLabel");

        this.setLayout(new FlowLayout());
        this.add(rOne);
        this.add(rTwo);
        this.add(combo);
        this.add(label);


    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class ROneAction implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            combo.removeAllItems();
            combo.addItem("One");
        }
    }

    private class RTwoAction implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            combo.removeAllItems();
            combo.addItem("Two");
        }
    }

       private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
   label.setText("selected");

}

    public static void main(String[]args)
    {
        new ComboIssue();
    }



       }