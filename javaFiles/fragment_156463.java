if (ImageData!=null){
    Log.d(TAG,"Image Data is Not Null  "+ImageData);
    userGridWrapper.setUpload(true);
    if (userGridWrapper.isUpload()){
        holder.imageButton.setImageResource(R.drawable.ic_clear_black_24dp);
        Picasso.with(context).load(ImageData)
                .into(holder.imageView);
    }
}
else{
    holder.imageButton.setImageResource(R.drawable.ic_add_black_24dp);
}