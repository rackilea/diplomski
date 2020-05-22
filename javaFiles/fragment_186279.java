if (!restaurant.getActive()) {
    holder.isClosed.setVisibility(View.GONE);
} else{
    holder.isClosed.setVisibility(View.VISIBLE);
}

if (restaurant.getIsFavourite()) {
    holder.isFavourite.setImageResource(R.drawable.ic_icon_star_ppdcolor);
} else{
    holder.isFavourite.setImageResource(R.drawable.your_icon_when_not_favourite);
}