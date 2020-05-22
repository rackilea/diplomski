public class FragmentC  extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
               View v = inflater.inflate(R.layout.frag4, container, false);
    // here v is the View you inflated from frag4.xml
    Button button = (Button) v.findViewById(R.id.button);

    // Capture button clicks
    button.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {

            // Start NewActivity.class
            Intent myIntent = new Intent(getActivity(),eventload.class);
            startActivity(myIntent);
        }
    });
    return v;
    }
}