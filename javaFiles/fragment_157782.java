ImageView iv = (ImageView ) convertView.findViewById(R.id.imagePreview);
ContentResolver crThumb = getContentResolver();
BitmapFactory.Options options=new BitmapFactory.Options();
options.inSampleSize = 1;
Bitmap curThumb = MediaStore.Video.Thumbnails.getThumbnail(crThumb, id, MediaStore.Video.Thumbnails.MICRO_KIND, options);
iv.setImageBitmap(curThumb);