class TPagerIndicator extends HorizontalCirclePagerIndicatorDecoration {
   TPagerIndicator(
         final int colorActive,
         final int colorInactive) {
      super(colorActive, colorInactive, 12.3F /* Explicit set */);
   }

   TPagerIndicator(
         final int colorActive,
         final int colorInactive
         final int mIndicatorItemLength) {
      super(colorActive, colorInactive, mIndicatorItemLength /* Input set */);
   }

   ...
}