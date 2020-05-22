class Main
{
  public static void main(String[] arg)
  {
    MainPanel mp = new MainPanel();
    mp.fct();
  }
}

class MainPanel extends Panel
{
  SecondPanel sp;
  MainPanel()
  {
    sp = new SecondPanel();
  }
  void fct()
  {
    //the mainPanel can access member tf of second panel
    System.out.println(sp.tf.getText());
  }
}

class SecondPanel extends Panel
{
  TextField tf;
  SecondPanel()
  {
    tf = new TextField("Abcde");
    this.add(tf);
  }
}