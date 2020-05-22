public abstract class MigLayoutPanel extends JPanel {

      public MigLayoutPanel() {
           this(new MigLayout());
      }

      private MigLayoutPanel(LayoutManager layout) {
           super(layout);
      }

      @Override
      public void setLayout(LayoutManager layout) {
          if(!(layout instanceof MigLayout)){
              throw new UnsupportedOperationException("not allowed to change the layout");
          }
      }
}