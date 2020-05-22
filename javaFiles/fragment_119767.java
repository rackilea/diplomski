// GUI class
public class GuiClass {
   private JList items; // declare this in the *class*

   // class's constructor
   public GuiClass() {
     ArrayList<Item> i = g.getAllItems(); 
     Vector allItemsVector = new Vector(i); 

     // JList items = new JList(allItemsVector); // don't re-declare in constructor
     items = new JList(allItemsVector); 

     panel.add( new JScrollPane( items ))
   }