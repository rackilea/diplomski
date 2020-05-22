public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

    List<Integer> xPositions = new ArrayList<>();

    // ... all the needed stuff.

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            holder.showX();
            xPositions.add(holder.getAdapterPosition());
            checkIfShouldShowAlert();
        });
    }

    void checkIfShouldShowAlert() {
        // do your checks on xPositions and show the AlertDialog if needed
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cellTextView;

        ViewHolder(View itemView) {
            super(itemView);
            cellTextView = (TextView) itemView.findViewById(R.id.textView);
        }

        void showX(){
            cellTextView.setText("X");
        }
    }
}