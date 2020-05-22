public class PlaceholderFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {}

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_activity_beam_rec, container, false);

        final EditText etxb;
        etxb = (EditText) rootView.findViewById(R.id.editText);
        final Button buDesign = (Button) rootView.findViewById(R.id.buDesign);

        buDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double b;
                b = Double.valueOf(etxb.getText().toString());

                //here i want the button to create the second fragment and pass the variable d to it
                int nextSectionNumber = ((ActivityBeamRec) getActivity()).getNextSectionNumber();
                ((ActivityBeamRec) getActivity()).addFragment(PlaceholderFragment.newInstance(nextSectionNumber));
            }
        });
        return rootView;
    }
}