public static Bitmap getFacebookProfilePicture(String userID) throws IOException {
                URL imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
                Bitmap bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

                return bitmap;
            }

   // on createView method 

            try {
                Bitmap mBitmap = getFacebookProfilePicture(id);
                imageView.setImageBitmap(mBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }