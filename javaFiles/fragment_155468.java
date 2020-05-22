public class Frag_a extends Fragment {

    FragBHandler fragBHandler;

    public Frag_a() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        // context is the activity's context.
        super.onAttach(context);

        try {
            // This makes sure that the container activity has implemented
            // the callback interface. If not, it throws an exception
            fragBHandler = (FragBHandler) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
            Log.e("", "onAttach: class has not implemented fragAhandler");
        }
    }
    // THIS SHOULD NEVER BE AN APPROCH.
    // public Frag_a(FragBHandler fragBHandler) {
    // this.fragBHandler = fragBHandler;
    // }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_a, container, false);
        v.findViewById(R.id.bt_open_frag2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFrag2();
            }
        });
        v.findViewById(R.id.bt_close_frag2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFrag2();
            }
        });

        return v;
    }

    public void closeFrag2() {
        fragBHandler.closeFrag2();

    }

    public void openFrag2() {
        fragBHandler.addFrag2();

    }

}