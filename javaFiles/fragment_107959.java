@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_redirect, container, false);

    recylcerView =(RecyclerView) v.findViewById(R.id.recyclerView);
    LinearLayoutManager manager = new LinearLayoutManager(getContext());
    recylcerView.setLayoutManager(manager);
    recylcerView.setHasFixedSize(true);

    searchList = new ArrayList<>();



    List<Search> searchList = new ArrayList<>()
    SearchAdapter adapter1 = new SearchAdapter(getContext(),searchList);
    recylcerView.setAdapter(adapter1);
    loadSearch();

    return v;

}