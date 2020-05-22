public class Main extends Activity {

    private boolean showingFirstFragment;            

    public void onCreate(Bundle savedInstanceState){

        setContentView(R.layout.main);

        FragmentManager manager = getFragmentManager();

        FragmentTransaction trans = manager.beginTransaction();

        // Keep track of which Fragment we are facing.
        showingFirstFragment = true;

        // Add the first Fragment to the container.
        trans.add(R.id.main_container, new Fragment1(), "fragment_1");

        trans.commit();
    }

    public void onBackPressed(){

        // Override the back button functionality to simply switch 
        // Fragments. Note that this would normally be done in a click
        // click listener.
        switchFragments();
    }

    private void switchFragments(){

        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        // Set the animations that will emulate the functionality you
        // requested.    
        int rightIn = R.animator.slide_right_in;
        int rightOut = R.animator.slide_right_out;
        int leftIn = R.animator.slide_left_in;
        int leftOut = R.animator.slide_left_out;

        // Note that we pass in 4 animations here.  Please see the 
        // documentation on this method as it is critical to the 
        // understanding of this solution.
        trans.setCustomAnimations(rightIn, leftOut, leftIn, rightOut);          

        if(showingFirstFragment){

            int container = R.id.main_container;                

            // Show the second Fragment.
            trans.replace(container, new Fragment2(), "fragment_2");
            trans.commit();

            showingFirstFragment = false;    
        }
        else{

            // Show the first Fragment by popping the back stack!
            manager.popBackStack(null);

            showingFirstFragment = true;
        }
    }
}