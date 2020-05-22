public class FragmentNewsItems extends Fragment implements AdapterView.OnItemClickListener{


View view;
    private RecyclerView recyclerView;
    private List<NewsItems> cyberNews;
    private FragmentNewsItems fragmentNewsItems;

    public FragmentNewsItems(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f_news_items_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.news_items_recycler_view);

        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), cyberNews);
// add this line
recyclerAdapter .setOnItemClickListener(this);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cyberNews = new ArrayList<>();
        cyberNews.add(new NewsItems(R.drawable.cyber1, "The  of cybersecurity in 5G-connected world"));
        cyberNews.add(new NewsItems(R.drawable.cyber2, "Google discovered several iPhone security flaws, and Apple still hasn't patched one"));
        cyberNews.add(new NewsItems(R.drawable.cyber3, "WhatsApp and Telegram media files aren't so secure"));
        cyberNews.add(new NewsItems(R.drawable.cyber4, "Microsoft Exposes Russian Cyberattacks on Phones, Printers, Video Decoders"));
        cyberNews.add(new NewsItems(R.drawable.cyber5, "Tesla demonstrated the power of The Internet of Things"));

    }


@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// here open new activity or replace fragment which have webview.
}