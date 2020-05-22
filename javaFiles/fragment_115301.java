public class MyTree extends JTree {
   public MyTree() {
       final MyTreeModel m = new MyTreeModel()
       super.setTreeModel(m);
       super.setSelectionModel(m.getSelectionModel());
   }

  /**
   * your tree model implementation which fiddles
   * with sm when "move" is called
   */       
   private class MyTreeModel implements TreeModel() {
       private final DefaultTreeSelectionModel sm;

       public MyTreeModel() {
           this.sm = new DefaultTreeSelectionModel();
       }

       public TreeSelectionModel getSelectionModel() { return this.sm; }
   }

}