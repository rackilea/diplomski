private static final List<MultiFallBackTarget> TARGETS = new ArrayList<MultiFallBackTarget>();

public static class MultiFallBackTarget implements Picasso.Target {

   private WeakReference<ImageView> weakImage;
   private List<String> fallbacks;

   public MultiFallBackTarget(ImageView image){
      weakImage = new WeakReference<>(image);
      fallbacks = new ArrayList<String>();
      TARGETS.add(this);
   }

   public void addFallback(String fallbackUrl){
      fallbacks.add(fallbackUrl);
   }

   public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from){

      removeSelf();

      ImageView image = weakImage.get();
      if(image == null) return;

      image.setImageBitmap(bitmap);
   }
   public void onBitmapFailed(Drawable errorDrawable){
      ImageView image = weakImage.get();
      if(image == null) {
          removeSelf();
          return;
      }

      if(fallbacks.size() > 0){
         String nextUrl = fallbacks.remove(0);
         // here you call picasso again
         Picasso.with(image.getContext()).load(nextUrl).into(this);
      } else {
         removeSelf();
      }
   }
   public void onPrepareLoad(Drawable placeHolderDrawable){}

   private void removeSelf(){
       TARGETS.remove(this);
   }
}