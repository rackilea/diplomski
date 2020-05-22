@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_profile,container, false); //<--- Added false!
    initViews(view);
    return view;
}