public class Object extends[whatever you like] implements [whatever you want]{

public boolean1=false;
public PropertyChangeSupport changes = new PropertyChangeSupport(this);

public void yourapplication(){
//you're doing whatever you're application does here
...
boolean1=true; //something happened (maybe the player lost)
this.changes.firePropertyChange("boolean1",false,true); // So we tell our listener
... 
// the rest of your application happens 
         } 
}