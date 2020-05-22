public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTitle,tvArtis,tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgVideo);
            tvArtis = itemView.findViewById(R.id.tvartis);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            YOUR_VIEW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"Position==>> "+getAdapterPosition(),Toast.LENGTH_LONG).show();

                    DataVideo video = datas.getContent().get(viewHolder.getAdapterPosition()); // ERROR HERE
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra("datas",video);
                    context.startActivity(intent);

                }
            });
    }
}