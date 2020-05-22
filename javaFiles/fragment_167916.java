@Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name, idTV;

        inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
        picture = (ImageView) v.findViewById(R.id.picture);
        name = (TextView) v.findViewById(R.id.manufacturer_name);
        idTV = (TextView) v.findViewById(R.id.manufacturer_id);

        HashMap<String, String> itemHash = (HashMap<String, String>) getItem(i);
        String nameString = itemHash.get(TAG_NAME);
        String iconUrl = itemHash.get(TAG_ICONNAME);
        String idString = itemHash.get(TAG_ID);

        // Use an image loader to load your Photo from URL.
        Picasso.with(context).load(iconUrl).into(picture);

        idTV.setText("ID: "+idString);
        name.setText("Name: "+nameString);
        return v;
    }