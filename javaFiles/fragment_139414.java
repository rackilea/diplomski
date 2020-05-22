public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {                                                                                                                                                                                                                                                           
    View _view = inflater.inflate(R.layout.fragment1, container, false);

    ListView _list= (ListView) _view.findViewById(R.id.main_events);
    return _view;
}