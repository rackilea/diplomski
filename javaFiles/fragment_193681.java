public class ExampleFragment {

    //Create the interface that will be used to communicate with the
    //Activity. For simplicity, we'll just call it UsersProvider.
    //Whichever Activity uses this Fragment will implement this interface.
    public interface UsersProvider {
        public ArrayList<User> getUsers();
    }

    //Our UsersProvider reference. 
    private UsersProvider usersProvider;

    //Here is where we'll set the Activity as our UsersProvider.
    //We're still calling getActivity(), but we're not casting it to
    //any specific Activity, rather we're casting it as the interface.
    @Override 
    public void onAttach(Context context) {
        usersProvider = (UsersProvider) getActivity();
    }

    // onCreate, onCreateView etc... goes here
}