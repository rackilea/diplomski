public class MainActivity extends AppCompatActivity implements WordAdapter.OnNoteListener {
    private RecyclerView recyclerView;
    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.home_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<Word> wordList = new ArrayList<>();


        wordList.add(new Word(R.drawable.ic_launcher_background, "dd"));
        wordList.add(new Word(R.drawable.ic_launcher_background, "ss"));
        wordList.add(new Word(R.drawable.ic_launcher_background, "cc"));


        WordAdapter adapter = new WordAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.addItems(wordList);
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "clicked on the position:" + position);
    }
}

    public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private List<Word> wordList;
    private OnNoteListener mOnNoteListener;

    public WordAdapter(List<Word> wordList, OnNoteListener onNoteListener) {
        this.wordList = wordList;
        this.mOnNoteListener = onNoteListener;
    }

    public WordAdapter(OnNoteListener onNoteListener) {
        this(new ArrayList<Word>(), onNoteListener);
    }

    public void addItems(List<Word> items) {
        wordList.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        wordList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        int resource = wordList.get(position).getImageResource();
        String title = wordList.get(position).getTitle();
        viewholder.setData(resource, title);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView title;

        private OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.word);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        private void setData(int resource, String titleText) {
            imageView.setImageResource(resource);
            title.setText(titleText);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}