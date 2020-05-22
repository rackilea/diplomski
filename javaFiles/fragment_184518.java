@Override
public void onBindViewHolder(MyViewHolder holder, int position) {

    //This will get the current position of the Information object from the Information array
    SubInformation current = data.get(position);

    holder.title.setText(current.getTitle());

    //add the click listener
    holder.root.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (getAdapterPosition()) {
                case 0:
                    //Toast.makeText(v.getContext(), "Default Case", Toast.LENGTH_SHORT).show();
                    //break;
                    intent = new Intent(context, AdminTeam.class);
                    //intent.putExtra("JSON Admin", ra.getItemCount());
                    break;

                case 1:
                    Toast.makeText(v.getContext(), "Default Case", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

            //In order for an activity to begin, a context needs to be passed in
            //context.startActivity(new Intent(context, Introduction.class));
            context.startActivity(intent);
            //If the method is not called (Error handling to avoid NULL POINTER EXCEPTION ERROR)
            if (clickListener != null) {
                //Trigger the appropriate call. getPosition will get the latest position of the item clicked by the user
                clickListener.itemClicked(v, getAdapterPosition());
            }

        }
    });
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView title;
    View root; //save the root view and add the click listener on it in OnBindViewHolder

    public MyViewHolder(View itemView) {
        super(itemView);
        root = itemView;

        //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
        title = (TextView) itemView.
                findViewById(R.id.listText);
    }


}