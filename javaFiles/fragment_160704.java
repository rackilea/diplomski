itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, DetailActivity.class);
    //addthis       i.putExtra(DetailActivity.MOVIE, entListMovie.get(getPosition()));
                    context.startActivity(i);
                }
            });