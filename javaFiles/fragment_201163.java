public class Fragment3 extends Fragment implements GetData.Callback {

    private ListView listView;
    private ArrayList<ArticleConstructor> articleConstructors = new ArrayList<>();
    private ArticleArrayAdapter adapter;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        adapter = new ArticleArrayAdapter(getActivity(), getContext(), articleConstructors);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (articleConstructors.size() == 0) {
            GetData getData = new GetData(this);
            getData.execute("lincoln");
        }
    }

    @Override
    public void onArticleConstructorLoaded(ArrayList<ArticleConstructor> articleConstructors) {
        this.articleConstructors = articleConstructors;
        adapter.setArticleConstructors(articleConstructors);
    }
}