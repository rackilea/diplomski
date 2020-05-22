public class Main extends Activity{
private Object obj;
public PropertyChangeListener listener;

@Override
protected void onCreate(Bundle savedInstanceState) {
    obj= new Object(this);
    listener= new PropertyChangeListener() { //This is how we define the listener and tell it what to do when it hears something change
        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (obj.boolean1) {
                dothing1();
                obj.boolean1=false;
            }
        }
    };
    obj.changes.addPropertyChangeListener(listener); //The Support class binds the property change listener to our Object
          }
}