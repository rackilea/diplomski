Bitmap image1=BitmapFactory.decodeResource(getResources() ,R.drawable.icon1);
Bitmap image2=BitmapFactory.decodeResource(getResources() R.drawable.icon2);
Bitmap result = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(result);//Create the canvas to your image
Rect srcRect = new Rect(0, 0, image.getWidth(), image.getHeight());
Rect dstRect = new Rect(srcRect);
dstRect.offset(15, 0);      
canvas.drawBitmap(image, srcRect, dstRect, null); //draw on it
dstRect.offset(image.getWidth(), 0);    
canvas.drawBitmap(image2, srcRect, dstRect, null);
return result;//result will have the drawed images from the canvas