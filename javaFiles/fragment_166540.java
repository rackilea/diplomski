public class ImageAdapter extends RecyclerView.Adapter { 
    List<City> listaPaisesFiltrados; 

    ImageAdapter(List<City> listaPaisesFiltrados) {
    this.listaPaisesFiltrados = listaPaisesFiltrados;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int             viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.city_thumnail_view, parent, false);


        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
    City city = listaPaisesFiltrados.get(position);

    holder.cityNameTextView.setText(city.getCityName());    
    Glide.with(holder.imageView.getContext()).load(imageUrl).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listaPaisesFiltrados.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView cityNameTextView;

            public ImageViewHolder(View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.imgPaisFiltrado);
            cityNameTextView = itemView.findViewById(R.id.cityNameText);
        }
    }
}