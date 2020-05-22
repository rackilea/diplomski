public class Model {
   private List<String> values = new ArrayList<String>();
   public void add(String s) {
      values.add(s);
   }
   public void remove(String s) {
      values.remove(s);
   }
   public void get(i) {
      values.get(i);
   }
   // ...

}   

public static void main(String[] args) {

 JFrame f= new JFrame ("My Frame");
 f.setDefaultCloseOperation (JFrame .EXIT_ON_CLOSE);

 JTabbedPane tp = new JTabbedPane();
 Model model = new Model();
 tp.addTab("Pane1", new PaneFirst(model));
 tp.addTab("Pane2", new PaneSecond(model));

 f.add(tp);
 f.pack();
 f.setVisible(true);
}