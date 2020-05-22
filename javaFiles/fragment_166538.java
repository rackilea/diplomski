@Override
public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
    myCityNameObject city = listaPaisesFiltrados.get(holder.getAdapterPosition());

    textView.setText(city.cityName);    
    Glide.with(holder.imageView.getContext()).load(imageUrl).centerCrop().into(holder.imageView);
}