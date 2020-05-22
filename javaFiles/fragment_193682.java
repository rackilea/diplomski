public class MainActivity extends Activity implements ExampleFragment.UsersProvider {

    //It's assumed that this is set somewhere else in the acitivty.
    private ArrayList<User> users;

    //onCreate, etc...

    //Implement the method from UsersProvider interface
    @Override 
    public ArrayList<User> getUsers() {
        return users;
    }
}