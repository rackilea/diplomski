public class custom_adapter extends ArrayAdapter<String>{

    ArrayList<String> name = null;
    ArrayList<String> gender = null;
    ArrayList<String> latitude = null;
    ArrayList<String> longitude = null;
    Context activity_context = null;

    public custom_adapter(Context context,
                          int resource,
                          ArrayList<String> name ,
                          ArrayList<String> gender,
                          ArrayList<String> latitude,
                          ArrayList<String> longitude) {
        super(context, resource, name );
        this.name = name;
        this.gender = gender;
        this.latitude = latitude;
        this.longitude = longitude;
        activity_context = context;
    }


    static class ViewHolder
    {
        public TextView txt_name;
        public TextView txt_gender;
        public TextView txt_latitude;
        public TextView txt_longitude;
        public ImageView img_view;
    }


    @Override
    public View getView (final int position,
                         View      convertView,
                         ViewGroup parent)
    {
        View rowView = convertView;
        ViewHolder holder = null;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater)activity_context.getSystemService(
                                               Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_file, null, false);
            holder = new ViewHolder();
            holder.txt_name = (TextView) rowView.findViewById(R.id.textView1);
            holder.txt_gender = (TextView) rowView.findViewById(R.id.textView2);
            holder.txt_latitude = (TextView) rowView.findViewById(R.id.textView3);
            holder.txt_longitude = (TextView) rowView.findViewById(R.id.textView4);
            holder.img_view = (ImageView) rowView.findViewById(R.id.imageView1);
            rowView.setTag(holder);

        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        if (holder != null) {
            holder.txt_name.setText(name.get(position));
            holder.txt_gender.setText(gender.get(position));
            holder.txt_latitude.setText(latitude.get(position));
            holder.txt_longitude.setText(longitude.get(position));
        }
        return rowView;
    }
}