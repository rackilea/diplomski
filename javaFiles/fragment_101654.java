public class Test{
  public static void main(String []args){
     jcurses.system.InputChar ch;
     ch=jcurses.system.Toolkit.readCharacter(); 
     System.out.println(ch.getCode());
  }
}