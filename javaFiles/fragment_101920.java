//This is in your MainActivity, note you're imlementing the new MyInterface interface
public class MainActivity extends Activity implements HomeFragment.OnFragmentInteractionListener, MyInterface {
  ...
  @Override
  public void changeTheButton(/*The parameters you need to send form the fragment to the a
  Activity*/){
    //This is where you receive the parameters from fragment, and change the button text as you need.
  }
}