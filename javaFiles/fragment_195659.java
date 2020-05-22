public class MyView{
  private MyPresentationModel model;

  private JButton okButton;
  private JButton cancelButton;
  ...

  public MyView(MyPresentationModel model){
    this.model = model;
  }

  public JPanel buildView(){
    initComponents(); // this method actually creates the okButton and cancelButton objects
    bindComponentsToModel(); // this method binds those objects to the PresentationModel
    JPanel p = new JPanel(new MigLayout());
    p.add(...);
    ...
    return p;
  }
}