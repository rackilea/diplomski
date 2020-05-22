if (currentItem.getScavengerHuntImage() != null) {
        scavengerHuntViewHolder.scavengerHuntLayoutImageView.setImageBitmap(currentItem.getScavengerHuntImage());
        Log.d("in adapter UPDATED POS", "position  =  " + i);
    } else {
scavengerHuntViewHolder.scavengerHuntLayoutImageView.setImageResource(android.R.color.transparent);
//or
//scavengerHuntViewHolder.scavengerHuntLayoutImageView.setImageBitmap(null);
}