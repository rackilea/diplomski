public class Foo extends JFrame{
  private JButton login;
  public Foo(){ //....}
  @Override 
  public void actionPerformed(ActionEvent ev){
    if(ev.getSource()==login){ 
      //.....
      //first way to pass the values
       new Bar("value1","value2");
      //or
      Bar bar = new Bar();
      bar.setValue1("value1");
      bar.setValue2("value2");

    }
  }
}