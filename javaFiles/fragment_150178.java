public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_countryfragment,container,false);
        desc = (TextView) view.findViewById(R.id.desc);
        ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(getActivity(), desc);
        connectionAsyncTask.execute("http://www.mocky.io/v2/570d3677270000f600dc29b6");

        return view;
    }