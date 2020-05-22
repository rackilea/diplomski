package B;
import A.*;
public class ProtectChecker {
   NewClassA x = new NewClassA(); //Cannot instantiate abstract NewClassA
   NewClassA y = new NewClassB(); //OK

   String str = y.getString();   //Error convert to getString() to public
}