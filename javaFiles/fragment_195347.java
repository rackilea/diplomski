String _userName;
EditText editus_ername;

public FragmentClassName(String userName){
_userName = userName;
}



   public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);

            editus_ername = (EditText)getActivity().findViewById(R.id.editUserName);

            editus_ername.setText(_userName);

        return rootView;


    }