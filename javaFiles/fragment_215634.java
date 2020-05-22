public class TopPanel extends JPanel 
{
  private TheTable table;

  public TopPanel()
  {
    table = new TheTable(this);
  }

  public void methodToFire() { }
}

public class TheTable extends JTable 
{
  private TopPanel panel;

  public TheTable(TopPanel panel)
  {
    this.panel = panel;

    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        doThing();
      }
    } );
  }

  private void doThing()
  {
    this.panel.methodToFire(); 
  }
}