public class Adapter extends RecyclerView.Adapter<MyRecycleViewHolder> {

    public interface Callbacks {
        public void onButtonClicked(String titleKey);
    }

    private Callbacks mCallbacks;

    public Adapter() {

    }

    @Override
    public MyRecycleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_details, null);
        return new MyRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyRecycleViewHolder holder, final int i) {

        holder.ExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallbacks != null) {
                    mCallbacks.onButtonClicked(holder.ProbTitle.getText().toString());
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return;
    }

    public void setCallbacks(Callbacks callbacks) {
        this.mCallbacks = callbacks;
    }
}