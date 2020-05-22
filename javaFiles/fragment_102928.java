public class ZivotinjeAdapter extends RecyclerView.Adapter<ZivotinjeAdapter.ViewHolder> {

    @Override
    public ZivotinjeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_zivotinje, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ZivotinjeAdapter.ViewHolder viewHolder, int position) {

        Zivotinje zivotinjeIme = mZivotinje.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(zivotinjeIme.getmAnimal_name());

        ImageView slika_source = viewHolder.imageView;
        slika_source.setImageResource(zivotinjeIme.getmAnimal_slika());

       viewHolder.setItem(mZivotinje[position]);




    }


    @Override
    public int getItemCount() {
        return mZivotinje.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTextView;
        private Zivotinje mItem;





        public ViewHolder(final View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.zivotinjaIme_id);
            imageView = (ImageView) itemView.findViewById(R.id.slika_id);


 public void setItem(Zivotinje item) {
            mItem = item;

        }




            //It works when i play for each item sound but how to play specific sound for each animal
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                      // here you will get mItem and from that you can get the sound
                    MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.clock);
                    mediaPlayer.start();
                }
            });

        }
    }

    private List<Zivotinje> mZivotinje;

    public ZivotinjeAdapter(List<Zivotinje> animals) {
        mZivotinje = animals;
    }
}