public class BrowserPanel extends Composite {
   private static BrowserPanelUiBinder uiBinder = 
   GWT.create(BrowserPanelUiBinder.class);
   interface BrowserPanelUiBinder extends   UiBinder<Widget, BrowserPanelPanel> {}

   public BrowserPanel() {
   initWidget(uiBinder.createAndBindUi(this));
   }
}