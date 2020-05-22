public class FeedsListAdapter extends RecyclerView.Adapter<FeedsListAdapter.ViewHolder> {
    // ...

    /***** Creating OnItemClickListener *****/

    // Define listener member variable
    private OnItemClickListener listener;

    // Define the listener interface
    public interface OnItemClickListener {
        void onAutoLinkTextClick(String companyId);
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void onBindViewHolder(MyHolder holder, int position) {

        ...
        holder.messages.setAutoLinkOnClickListener(new AutoLinkOnClickListener() {
            @Override
            public void onAutoLinkTextClick(AutoLinkMode autoLinkMode, String matchedText) {
              listener.onAutoLinkTextClick(f.getCompanyId());

            }
        });
        ...

    }
}