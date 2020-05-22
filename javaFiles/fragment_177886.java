public enum Weathers {

   RAINING(R.drawable.ic_raining),
   SNOWING(R.drawable.ic_snowing);

   private int iconResId;

   private Weathers(int iconResId) {
      this.iconResId = iconResId;
   }
   public int getIconResId() {
      return iconResId;
   }
}