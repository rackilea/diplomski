public class SimpleItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView country;
    TextView population;
    ImageView flag;

    public SimpleItemViewHolder(View itemView) {
        super(itemView);
        country = (TextView) itemView.findViewById(R.id.country);
        population = (TextView) itemView.findViewById(R.id.population);
        flag = (ImageView) itemView.findViewById(R.id.flag);
        // register listener
        itemView.setOnClickListener(this);
    }

    Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        // your code here
    }

}