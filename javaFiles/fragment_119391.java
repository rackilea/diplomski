public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    View rootview = inflater.inflate(R.layout.index, container, false);

    Index=(Button)rootview.findViewById(R.id.index_page);
    Share=(Button)rootview.findViewById(R.id.share_page);
    btn_click();
    return rootview;
}