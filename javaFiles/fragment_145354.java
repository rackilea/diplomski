if (convertView == null) {
   ...
} else {
   ...
}
textViewAndroid.setText(gridViewString[i]);
Picasso
       .with(mContext)
       .load(gridViewImageId[i])
       .fit() // will explain later
       .into((ImageView) imageViewAndroid);
return gridViewAndroid;