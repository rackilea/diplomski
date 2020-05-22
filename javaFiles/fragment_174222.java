import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class ItemPanel extends JPanel {

    ItemPanel(String name, double cost){
        JLabel nameLabel = new JLabel();
        nameLabel.setText(name);
        this.add(nameLabel);  // added this!
        JCheckBox selectBox = new JCheckBox("$ " + cost);
        this.setForeground(new java.awt.Color(80, 80, 90));
        this.setSize(50, 50);
        this.add(selectBox);
    }
}