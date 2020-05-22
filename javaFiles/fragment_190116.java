import java.awt.Container;
 import java.awt.FlowLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.ItemEvent;
 import java.awt.event.ItemListener;
 import java.util.HashMap;
 import java.util.Map;
 import javax.swing.JButton;
 import javax.swing.JComboBox;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 public class SelectWindow extends JFrame implements
 ItemListener {
     JButton button1;
     JLabel texte;
      Container c;
 public static void main(String[] args) {
 new SelectWindow();
 }

 Map<String, String[]> cars = new HashMap<String,
 String[]>();
 JComboBox brands;
 JComboBox models;
 public SelectWindow() {
 initCars();
 setTitle("Select a car");
 brands = new JComboBox();
 brands.addItem("<none>");
 for (String brand : cars.keySet()) {
 brands.addItem(brand);
 }
 brands.addItemListener(this);
 models = new JComboBox();
 models.setEnabled(false);
 models.addItemListener(this);
 texte = new JLabel("car was selected");
 texte.setVisible(false);
 button1 = new JButton("OK");

 button1.addActionListener(new ActionListener() {

     public void actionPerformed(ActionEvent arg0) {

         texte.setVisible(true);
        // c.add(texte);
     }
        });

 c = getContentPane();
 c.setLayout(new FlowLayout());
 c.add(new JLabel("Select a brand: "));
 c.add(brands);
 c.add(new JLabel("Select a model: "));
 c.add(models);
 c.add(button1);
 c.add(texte);
 setVisible(true);
 }
 @Override
 public void itemStateChanged(ItemEvent e) {
 if (e.getSource() == brands && e.getStateChange() == ItemEvent.SELECTED) {
   String[] items = cars.get(e.getItem());
 if (items == null) {
    models.removeAllItems();
     models.setEnabled(false);

 } else {
     models.removeAllItems();
     models.addItem("<none>");
 for (String item : items) {
     models.addItem(item);
 }
      models.setEnabled(true);

 }

 button1.setEnabled(true);



     }



 }
private void initCars() {
   cars.put("Renault", new String[] {
   "Twingo", "Clio", "Modus", "Kangoo",
     "Mégane", "Sénic", "Laguna", "Expace" });
cars.put("Peugeot", new String[] {
 "107", "206", "207", "308", "407",
 "508", "607" });
 cars.put("Citroën", new String[] {
 "C1", "C3", "C4 Picasso", "C5", "C6", "C8",
     "Berlingo", "DS3" });
   }
 }