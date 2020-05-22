public class MyRecyclerViewAdapter extends RecyclerView.Adapter< MyRecyclerViewAdapter.ViewHolder> {

public interface OnButtonClickListener {
    void onButtonClick(String id);
}

private final List<String> items;
private final OnButtonClickListener listener;

public MyRecyclerViewAdapter(List<String> items, OnButtonClickListener listener) {
    this.items = items;
    this.listener = listener;
}

@Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout. recyclerview_row, parent, false);
    return new ViewHolder(v);
}

@Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(items.get(position), listener);
}

@Override public int getItemCount() {
    return items.size();
}

static class ViewHolder extends RecyclerView.ViewHolder {

    private Button joinButton;

    public ViewHolder(View itemView) {
        super(itemView);
        joinButton = (Button) itemView.findViewById(R.id. joinRV);
    }

    public void bind(final String id, final OnButtonClickListener listener) {
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(id);
            }
        });
    }
}}