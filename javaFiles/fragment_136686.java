@Override
public void onBindViewHolder(MainViewHolder holder, int position) {
    MainItem status = items.get(position);

    holder.bind(status);
}