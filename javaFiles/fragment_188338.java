@Override
public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.list_item, null);
    }

    TextView name_tv = (TextView) convertView.findViewById(R.id.name);
    ImageView iv = (ImageView) convertView.findViewById(R.id.pic);

    Home home = homelist.get(position);

    name_tv.setText(home.getName());
    iv.setImageResource(home.getPics());

    return convertView;
}