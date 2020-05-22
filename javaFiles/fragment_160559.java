public class FragmentTwo extends Fragment{

    TextView tv;
    String strtext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View ObjFrgOneView=inflater.inflate(R.layout.fragment_two, container, false);

        strtext = getArguments().getString("edttext");    


        return ObjFrgOneView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        tv=(TextView) getActivity().findViewById(R.id.textViewId);
        tv.setText(strtext);
    }

}