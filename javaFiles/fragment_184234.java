//BroadcastObserver.java
public interface BroadcastObserver {
    //methods methods 
   public void foo();
}

//MainActivity.java
public class MainActivity extends Activity implements BroadcastObserver{
 @Override
 public void foo(){

 }

}

public class MyClass {
  BroadcastObserver static observer;  // this should be set to by passing your MainActivity object, may be at the time when you initiate your MyClass object
  public static class MyBroadcastReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
     Toast.makeText(context, "!!!!.",
     Toast.LENGTH_LONG).show();
     if(someaction){
         observer.foo();
     }
  }


}