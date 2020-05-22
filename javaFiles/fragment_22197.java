@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_webview, container, false);

    Bundle bundle=getArguments(); 
    link = bundle.getString("link");   

    Toast.makeText(getActivity(), "2.: "+link, Toast.LENGTH_LONG).show(); //Output: "null"


    return view;
}