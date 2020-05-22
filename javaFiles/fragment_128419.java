public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPrice, text_seat;
        private ImageView imgLogo;
        private ConstraintLayout relativeL_row_voyage_view;
        private CardView cardV_row_voyage;
        ExpandableLayout expandable_layout;
        ProgressBar progressB_dialog_seat;

        private ViewHolder(View view) {
            super(view);
            view.findViewById(R.id.relative_seat);
            expandable_layout = view.findViewById(R.id.expandable_layout);
            progressB_dialog_seat = view.findViewById(R.id.progressB_dialog_seat);
            relativeL_row_voyage_view = view.findViewById(R.id.relativeL_row_voyage_view);
        }
    }

    public void onBindViewHolder(ViewHolder holder, int i) {
        Bus bus = busList.get(i);

        if (bus.isExpanded()) {
            holder.expandable_layout.expand();
        } else {
            holder.expandable_layout.collapse();
        }
        holder.progressB_dialog_seat.setVisibility(bus.isShowProgress() ? View.VISIBLE : View.INVISIBLE);

        holder.relativeL_row_voyage_view.setOnClickListener(new View.OnClickListener() {
            bus.setExpanded(!bus.isExpanded());
            bus.setShowProgress(true);
            notifyDataSetChanged();

            final Handler h = new Handler() {
                @Override
                public void handleMessage(Message message) {
                    bus.setShowProgress(false);
                    notifyDataSetChanged();
                }
            };
            h.sendMessageDelayed(new Message(), 5000);
        });
        ...
    }  
}