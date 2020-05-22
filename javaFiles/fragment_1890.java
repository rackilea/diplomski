class FactoryMaker{
  private static AbstractFactory pf=null;
  static AbstractFactory getFactory(String choice){
    if(choice.equals("a")){
        pf=new ChildAFactory();
    }else if(choice.equals("b")){
        pf=new ChildBFactory();
    } return pf;
  }
 }

// Client
public class Client{
  public static void main(String args[]){
    AbstractFactory pf= FactoryMaker.getFactory("a");
    SC sc = pf.sc(); // ChildA is initialized
   }
}