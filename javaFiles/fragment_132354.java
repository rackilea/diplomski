private List<Foo> foos;
private RecyclerView recyclerView;
private MapActivity mapView;
@Override
public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foo, parent,
            false);
    return new FooInfoViewHolder(view);
}