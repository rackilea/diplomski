//Implement View.OnClickListener
class ReyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView image;
    private TextView appName;

    private ReyclerViewHolder(final View v) {
        super(v);

        image = (ImageView) v.findViewById(R.id.image);
        appName = (TextView) v.findViewById(R.id.app_name);

        // Set the onClickListener
        v.setOnClickListener(this)
    }

    @Override
    public void onClick(View v) {

        // if (getAdapterPosition() != RecyclerView.NO_POSITION) {
              Context context = v.getContext();
              Intent intent = new Intent(context, aActivityClass.class);
              intent.putExtra(extraKey, extraValue);
              context.startActivity(intent)
        // }
    };
}