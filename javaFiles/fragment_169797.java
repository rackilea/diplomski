public interface Observer{

  public void update( Event arg );
}

public class Event{

  public int ID;
}

public Button implements Observer{

  public void update ( Event arg ){

     switch (arg.ID){

       case 1:  //Buttonsy handle events of type 1
         //do something useful;
         break;
       default:
         System.out.println("Buttons don't handle events of ID: " + arg.ID);
         break;
     }
  }
}

public ProgressBar implements Observer{

  public void update ( Event arg ){

     switch (arg.ID){

       case 2: //ProgressBars handle events of type 2 and 3
         //do something useful;
         break;
       case 3:
         //do something else useful;
         break;
       default:
         System.out.println("Progress bars don't handle events of ID: " + arg.ID);
         break;
     }
  }
}


public class Subject{

 private ArrayList<Observer> allUIControls;

 public registerControl( Observer control ){

   allUIControls.add( control );
 }

 public void updateControls ( Event arg ) {

   foreach ( Observer control in allUIControls ){

     //pass the event to each UI control, and let the EVENT decide if it can understand the Event.ID
     //its not the job of Subject to decide if the Observer is fit to handle the event. THIS IS NOT THE OBSERVER pattern.
     control.update( arg );
   }
 }
}