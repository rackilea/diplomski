override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val recipe = recipes[position]
    val itemView = holder.itemView
    itemView.like.image = ContextCompat.getDrawable(itemView.context,
            if(recipe.isFavorite) R.drawable.ic_star_before_like else R.drawable.ic_star_after_like)
}