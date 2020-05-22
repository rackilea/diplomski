LinearLayout lv;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);
    lv = (LinearLayout) rootView.findViewById(R.id.player_list);

    return rootView;
}