@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main,
                container, false);
        listView = (ListView) rootView.findViewById(android.R.id.list);

        return rootView;
    }