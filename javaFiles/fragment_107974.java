Do you need an ImageView inside an image?

 I used this code to get an image. 
 Send your view this method get as image.

       protected Bitmap ConvertToBitmap(ImageView image_view) {
        Bitmap map;
        image_view.setDrawingCacheEnabled(true);
        image_view.buildDrawingCache();
        return map=image_view.getDrawingCache();
    }

In ur adapter code


holder.img.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bitmap b = ConvertToBitmap(holder.img);;
            //now get bitmap used to assign 
            imageChat.put("message", b);
            Communicator.getInstance().emit("new chat message",
                    imageChat);
        }
    });