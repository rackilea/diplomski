Uri imageUri = Uri.parse(imagePath);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(new File(imageUri.getPath()).getAbsolutePath(), options);
                        int imageHeight = options.outHeight;
                        int imageWidth = options.outWidth;
                        if (imageHeight > 4096 || imageWidth > 4096) {
                            BitmapFactory.Options opts = new BitmapFactory.Options();
                            opts.inSampleSize = 4;
                            Bitmap bitmap = BitmapFactory.decodeFile(imageUri.toString(), opts);
                            viewHolder.imgAvatarLogoList3.setImageBitmap(bitmap);
                        } else {
                            Picasso.with(context)
                                    .load(new File(imageUri.getPath())) // Uri of the picture
                                    .into(viewHolder.imgAvatarLogoList3);
                        }