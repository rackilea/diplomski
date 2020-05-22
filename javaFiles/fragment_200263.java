public class FragmentA extends Fragment implements Observer{
 ...
 @Override
    public void update(Observable observable, Object data) {

        Logging.log("FragmentA observed the following from Routines: "+data);

    }
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {

        routines = new Routines(getActivity().getApplicationContext());

        ((MainActivity)getActivity()).actionObserver.addObserver(this);