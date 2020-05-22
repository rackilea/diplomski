public class MainAct extends AppCompatActivity {
private static MainAct instance;

public static MainAct getInstance() {
 if(instance != null)
    return instance;
}

// I think it is better to create the instance variable in the onCreate() method of the MainAct activity

onCreate(...)
{
.
.
.
instance = this;
...
}

public void registerObserver(OnReceiveListener observer){
observers.add(observer)
}
/* To avoid memory leaks, remember to unregister receivers when no longer observing */
public void unregisterObserver(OnReceiveListener observer) {
    observers.remove(observer);
}
notifyObservers(){
// call this method in the listener you want 

for( Observer obser : observers)
    obser. receivePreview(param )

}
...

//in fragment initialization: 
MainAct.getInstance().registerObserver(this)