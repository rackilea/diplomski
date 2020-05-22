public class PlaceResultAdapter extends RecyclerView.Adapter<PlaceResultAdapter.ViewHolder> {
    private ArrayList<NearbyPlaces.Result> placeModels;
    private Context context;


    public PlaceResultAdapter(Context context, ArrayList<NearbyPlaces.Result> placeModels) {
        this.placeModels=placeModels;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.place_result_item,viewGroup,false);
        return new PlaceResultAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceResultAdapter.ViewHolder viewHolder, int i) {
        viewHolder.place_name.setText(placeModels.get(i).getName());
        viewHolder.place_category.setText(placeModels.get(i).getTypes().get(0));
String image_url = placeModels.get(i).getIcon();
        //Picasso.get().load(image_url).into(viewHolder.car_image);
    }

    @Override
    public int getItemCount() {
        return placeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView place_image;
        private TextView place_name,place_category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            place_image= itemView.findViewById(R.id.image_view);
            place_name= itemView.findViewById(R.id.title);
            place_category= itemView.findViewById(R.id.category_text);
        }
    }
}