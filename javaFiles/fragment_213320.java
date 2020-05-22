import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.ImageView;
    import android.widget.TextView;

    import java.util.List;

    /**
     * Created by vklamm on 08.04.2016.
     * transfer hier MenuItem class
     * create Menu holder and bind it to view
     */
    public class MyAdapter extends ArrayAdapter<MenuItem> {

        private int resource;
        private List<MenuItem> data;
        private Context context;
        private MenuHolder menuHolder;

        public MyAdapter(Context context, int resource, Context context1) {
            super(context, resource);
            context = context1;
        }

        public MyAdapter(Context context, int resource, List<MenuItem> data) {
            super(context, resource, data);
            this.context = context;
            this.resource = resource;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(resource,parent,false);

                menuHolder = new MenuHolder();

                //create drawer_list_item layout where ours icons and labels are
                menuHolder.menuItemImg = (ImageView) convertView.findViewById(R.id.menuItemImg);
                menuHolder.menuItemTitle = (TextView) convertView.findViewById(R.id.menuItemTitle);
                convertView.setTag(menuHolder);
            }else {
                menuHolder = (MenuHolder) convertView.getTag();
            }

            MenuItem menuItem = data.get(position);
            if(menuItem!=null){
                menuHolder.menuItemImg.setImageResource(menuItem.getImageId());
                menuHolder.menuItemTitle.setText(menuItem.getTitle());
            }

            return convertView;
        }
        //created class for binding our icons and texts from view
        public class MenuHolder {
            ImageView menuItemImg;
            TextView menuItemTitle;
        }
    }