@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_main, container, false);
    mResult = (TextView) v.findViewById(R.id.tv_result);
    return view;
}