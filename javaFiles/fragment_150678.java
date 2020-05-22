public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    View grid;
    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (convertView == null) {
        grid = new View(mContext);
        grid = inflater.inflate(R.layout.grid_single, null);
    } else {
        grid = (View) convertView;
    }

    // Refresh view
    TextView textView = (TextView) grid.findViewById(R.id.grid_text);
    ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
    textView.setText(name[position]);
    Picasso.with(mContext).load(Uri.parse(Imageid[position])).error(R.drawable.ic_launcher).into(imageView);
    Log.d("picasso", Imageid[position]);

    return grid;
}