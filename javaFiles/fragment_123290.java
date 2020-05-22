public int getStatusBarHeight() { 
      int result = 0;
      int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (resourceId > 0) {
          result = getResources().getDimensionPixelSize(resourceId);
      } 
      return result;
}