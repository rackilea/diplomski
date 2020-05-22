public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflator.inflate(R.layout.row, parent, false);

    ImageView icon = (ImageView) rowView.findViewById(R.id.row_icon);
    TextView title = (TextView) rowView.findViewById(R.id.row_title);

    title.setText(proMenu[position]);

    String s = proMenu[position];

    if(s.equalsIgnoreCase("Home")){
        icon.setImageResource(R.drawable.icon_home);
    }

    else
        if(s.equalsIgnoreCase("Best Nearby")){
            icon.setImageResource(R.drawable.specialss);
        }