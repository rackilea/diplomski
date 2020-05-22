public class ImageButtonAdapter extends BaseAdapter {
   private Context mContext;

   // Constructor
   public ImageButtonAdapter(Context c) {
      mContext = c;
   }

   public int getCount() {
      return listCount;
   }

   public Object getItem(int position) {
      return null;
   }

   public long getItemId(int position) {
      return 0;
   }

   // create a new ImageButton for each item referenced by the Adapter
   public View getView(int position, View convertView, ViewGroup parent) {
      ImageButton imageButton ;

      if (convertView == null) {
         imageButton = new ImageButton (mContext);
         imageButton.setLayoutParams(lp);
      } 
      else 
      {
         imageButton = (ImageButton ) convertView;
      }
      imageButton.setBackgroundColor(Color.TRANSPARENT)
      return imageButton ;
   } 

}