@Override
public void onBindViewHolder(RecyclerViewHolder holder, int position) {
    holder.MoviePopularity.setText(String.valueOf(mMoviesItems.g‌​et(position).getPopu‌​larity()));
    Picasso.with(this.context).load(mMoviesItems.get(position).getPhoto()).into(holder.MoviePoster);
    holder.MovieName.setText(mMoviesItems.get(position).getName());
}