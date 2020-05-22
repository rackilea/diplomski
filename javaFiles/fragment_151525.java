@Override
public void onBindViewHolder(final Absadapter.ExViewHolder holder, final int position){
    ...
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i1=new Intent(context, Abdetails.class);
            i1.putExtra("POSITION", position);
            context.startActivity(i1);
        }
    }
    ...
}