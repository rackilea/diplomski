class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public interface SelectionListener {
        void onSelectionChanged(int newPosition, ViewModel viewModel);
    }

    private @NonNull WeakReference<SelectionListener> selectionListener =
            new WeakReference<>(null);

    public void setSelectionListener(@Nullable SelectionListener listener) {
        selectionListener = new WeakReference<>(listener);
    }

    public class ViewHolder extends RecyclerView.ViewHolder<ViewBinding> {
        ViewHolder(ViewBinding binding) {
            super(binding.getRoot());

            binding.setViewHolder(this);
            binding.setViewModel(new ViewModel());
        }

        public void onClick(ViewModel viewModel) {
            SelectionListener listener = selectionListener.get();
            if (listener != null) {
                listener.onSelectionChanged(getAdapterPosition(), viewModel);
            }
        }
    }
}