import java.awt.*;
  import javax.swing.*;
  import java.awt.event.*;

public class ComboBoxDemo extends JFrame {
   private JComboBox<String> states;

public ComboBoxDemo() {
    super("JComboBox Demo");
    states = new JComboBox<String>(new String[]{"Select a State",
        "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
        "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
        "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
        "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
        "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"});

    setLayout(new FlowLayout(FlowLayout.CENTER));
    add(states, BorderLayout.CENTER);

    states.addItemListener(
    new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {

            // now there's nothing happen when we select the first item
            if(states.getSelectedIndex()>0){
                System.out.println("YOU CLICK INDEX- "+states.getSelectedIndex());
           }
        }
    }
    );                     
}

 public static void main(String[] args) {
    ComboBoxDemo g = new ComboBoxDemo();
    g.setVisible(true);
    g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    g.setBounds(100, 100, 300, 300);
 }
 }