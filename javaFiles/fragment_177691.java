class HorizontalCirclePagerIndicatorDecoration {
   ...
   private final float mIndicatorItemLength;

   HorizontalCirclePagerIndicatorDecoration() {
      mIndicatorItemLength = DP * 4;
   }

   HorizontalCirclePagerIndicatorDecoration(
         final int colorActive, 
         final int colorInactive, 
         final int mIndicatorItemLength) {
      ...
      this.mIndicatorItemLength = mIndicatorItemLength;
   }

   ...
}