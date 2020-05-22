public class FragmentOne extends Fragment {


    private TextView one;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        one = (TextView) getActivity().findViewById(R.id.one);
        // Displaying the user details on the screen
        one.setText("kjhbguhjg");
    }
}