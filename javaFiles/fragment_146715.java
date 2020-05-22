public class Bar extends JFrame{
  private String value1;
  private String value2;
  //create setters and getters
  public setValue1(String value){
   value1 = value;
  }
  public setValue2(String value){
   value2 = value;
  }
 // ..... 

 //default construcor
 public Bar(){}
 //parametrize construcor
 public Bar(String value1,String value2){
  this();
  setValue1(value1);
  setValue2(value2);
 }
}