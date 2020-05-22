public class StackScreen extends MainScreen implements FieldChangeListener {

   private Vector rowData;

   public StackScreen() {
      super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);      

      // define the screen title
      Font titleFont = Font.getDefault().derive(Font.PLAIN, 30);
      CustomLabelField title = new CustomLabelField("Screen Title", 
            titleFont, Color.DARKRED, DrawStyle.HCENTER | Field.USE_ALL_WIDTH);        
      title.setPadding(10, 10, 10, 10);
      add(title);

      // populate a dummy set of model data
      rowData = new Vector();      
      Data one = new Data("Title 1", "Some footer info", 
            new String[]{ "First line of text", "Second line of text" }, 
            "image1.png");
      Data two = new Data("Title 2", "Some footer info", 
            new String[]{ "First line of text", "Second line of text" }, 
            "image2.png");
      rowData.addElement(one);
      rowData.addElement(two);

      // create a UI representation of each row's data
      for (int i = 0; i < rowData.size(); i++) {
         RowManager row = new RowManager(i, (Data)rowData.elementAt(i), 0);
         row.setPadding(10, 20, 10, 20);  // top, right, bottom, left pad
         row.setChangeListener(this);
         add(row);
      }
   }

   // invoked when buttons are clicked
   public void fieldChanged(Field field, int context) {
      Object cookie = field.getCookie();
      if (cookie instanceof Integer) {
         Integer rowIndex = (Integer) cookie;
         Dialog.alert("Button " + rowIndex + " clicked!");
      }
   }
}