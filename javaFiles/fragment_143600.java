public class frag1 extends Fragment {
...
Activity mactivity;

@Override
public void onAttach(Activity MainActivity) {
    super.onAttach(MainActivity);
    mactivity = MainActivity; 
}