public class Render extends JPanel {
JLabel envContainer; //<---- class instance
Render() {
  super();
  ImageIcon imageIcon = new ImageIcon("/path/to/img1");
  JLabel envContainer = new JLabel(imageIcon); //<---- overriden by local instance, hence class instance remains null
  super.add(envContainer);
}