package application; 

import java.util.Timer;
import java.util.TimerTask;

public class Application {
  public static String name = "Brad" ;

  public static void main ( String [ ] args ) {
    final String lastName = "Brad's last name";

    Timer time = new Timer ( );
    time.schedule ( new TimerTask ( ) {
      @Override
      public void run ( ) {
        System.out.println( "Name: " + name + " " + lastName ) ;
      }
    }, 0, 10000 );
  }
}