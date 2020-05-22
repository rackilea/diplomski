public class Fragment2 extends Fragment {

    public View onCreateView(LayoutInflater inf, ViewGroup vg, Bundle b){

        // Simply inflate the View from the .xml file.
        return inf.inflate(R.layout.fragment_2, vg, false);
    }

    public void onActivityCreated (Bundle savedInstanceState){

        View v = getView();

        FractionTranslateLinearLayout layout;
        layout = (FractionTranslateLinearLayout) v.findViewById(R.id.layout);

        // Move the entire View off to the right of the screen for now.
        layout.setFractionX(1.0f);               
    }
}