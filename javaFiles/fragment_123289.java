public int getNavBarHeight() { 
      int result = 0;
      int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      if (resourceId > 0) {
          result = getResources().getDimensionPixelSize(resourceId);
      } 
      return result;
}