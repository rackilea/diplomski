imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
           int width = imageView.getWidth();
           int height = imageView.getHeight();
           //you can add your code here on what you want to do to the height and width you can pass it as parameter or make width and height a global variable
           imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
});