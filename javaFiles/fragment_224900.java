public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 4) < 2 ? 2 : 1;
            }
        });

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(new MyAdapter());
    }

    private static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public int getItemViewType(int position) {
            return (position % 4) < 2
                    ? R.layout.horizontal
                    : R.layout.vertical;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(viewType, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.image.setImageResource(R.drawable.mouse);
            holder.text.setText("" + position);
        }

        @Override
        public int getItemCount() {
            return Integer.MAX_VALUE;
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.image);
            this.text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}