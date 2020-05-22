if (d.child("type").getValue(String.class)!=null&&d.child("type").getValue(String.class).equals("image")){
      Glide.with(c).load(d.child("image").getValue(String.class)).placeholder(R.drawable.background).centerCrop().into(holder.image);
      holder.image.setVisibility(View.VISIBLE);
}
else{
      holder.image.setVisibility(View.GONE);
}