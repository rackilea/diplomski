public class CustomGrid extends BaseAdapter{
        private Context mContext;
        private final ArrayList<String> web;
        private final ArrayList<Drawable> Imageid;

        public CustomGrid(Context c, ArrayList<String> web, ArrayList<Drawable> imageId ) {
              mContext = c;
              this.Imageid = imageId;
              this.web = web;
          }

        public void removeItem(int position){
             web.remove(position);
             Imageid.remove(position);
             notifyDataSetChanged();
        }

    ....
    }