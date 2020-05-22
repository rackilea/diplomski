public class ViewFragment extends Fragment {

    public TextView gunView, imsakView, sabahView, gunesView, ogleView, ikindiView, aksamView, yatsiView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflatedView = inflater.inflate(R.layout.content_main, container, false);
        gunView = (TextView) inflatedView.findViewById(R.id.gun);
        imsakView = (TextView) inflatedView.findViewById(R.id.imsak);
        sabahView = (TextView) inflatedView.findViewById(R.id.sabah);
        gunesView = (TextView) inflatedView.findViewById(R.id.gunes);
        ogleView = (TextView) inflatedView.findViewById(R.id.ogle);
        ikindiView = (TextView) inflatedView.findViewById(R.id.ikindi);
        aksamView = (TextView) inflatedView.findViewById(R.id.aksam);
        yatsiView = (TextView) inflatedView.findViewById(R.id.yatsi);
        update("1", "2", "3", "4", "5", "5", "6", "7", "8", "9");  //remove view from here
        // Inflate the layout for this fragment
        return inflatedView;
    }

    public void update(String tarih, String hicri, String gun, String imsak, String sabah, String gunes, String ogle, String ikindi, String aksam, String yatsi) {
        gunView.setText(gun);
        imsakView.setText(imsak);
        sabahView.setText(sabah);
        gunesView.setText(gunes);
        ogleView.setText(ogle);
        ikindiView.setText(ikindi);
        aksamView.setText(aksam);
        yatsiView.setText(yatsi);
    }
}