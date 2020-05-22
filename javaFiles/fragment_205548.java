public class ViewHolder {
   private View row;
   private TextView upperText = null, lowerText = null;

   public ViewHolder(View row) {
      this.row = row;
   }

   public TextView getUpperText() {
      if (this.upperText == null) {
         this.upperText = (TextView) inView.findViewById(R.id.someId);
      }
      return this.upperText;
   }

   public TextView getLowerText() {
      if (this.lowerText == null) {
         this.lowerText = (TextView) inView.findViewById(R.id.someId);
      }
      return this.lowerText;
   }
}