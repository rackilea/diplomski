String base64Image = product.getImage().split(",")[1];

byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

holder.imageView.setImageBitmap(decodedByte);