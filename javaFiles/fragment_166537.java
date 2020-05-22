public class ImageViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public ImageViewHolder(View itemView) {

        super(itemView);
        imageView = itemView.findViewById(R.id.imgPaisFiltrado);
        textView = itemView.findViewById(R.id.cityName);
    }
}