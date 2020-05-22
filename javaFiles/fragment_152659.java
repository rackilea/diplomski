itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        System.out.println("The click was captured");
        int position = getAdapterPosition();
        if(position!=RecyclerView.NO_POSITION && null!=listener){
            listener.onItemClick(getSnapshots().getSnapshot(position),position);
        }

        //Intent intent = new Intent(view.getContext(), learn_content.class);
        //view.getContext().startActivity(intent);
    }
});