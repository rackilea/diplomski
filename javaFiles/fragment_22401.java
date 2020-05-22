private OnRecyclerItemViewClickListener listener;

public Mesajlar_Adapter(List<Mesajlar> resultModels, Context context, OnRecyclerItemViewClickListener listener) {
    ...
    this.listener = listener;
}

...

@Override
public void onBindViewHolder(final ViewHolder holder, final int position) {
    if (resultModels.get(position).isClicked()) {
        // change pressed background color here!
    } else {
        // change default background color here!
    }

    holder.itemView.setOnClickListener(v -> {
      listener.onClicked(position, resultModels.get(position));
    });
...
}