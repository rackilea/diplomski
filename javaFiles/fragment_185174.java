public class PanelFlowers extends javax.swing.JPanel {

     private int amount;
     // private String color = "";
     Color chosenColor;
     public PanelFlowers() {
         initComponents();
         // repaint(); // <--- no need to call repaint in constructor
     }

  private void initComponents() {

     // your other code------------

   DefaultComboBoxModel model = new DefaultComboBoxModel();
   model.addElement(new Color(152, 52, 152));
   model.addElement(new Color(152, 12, 52));
   model.addElement(new Color(152, 142, 120));
   colorCombo.setModel(model);


   colorCombo.addItemListener(new ItemListener() {


        @Override
        public void itemStateChanged(ItemEvent e) {

            JComboBox comb = (JComboBox)e.getSource();
            chosenColor = (Color) comb.getSelectedItem();
            repaint();

        }
    });