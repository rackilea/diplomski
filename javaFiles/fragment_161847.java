public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if (convertView == null)
        view = inflater.inflate(R.layout.listelement, null);
    TextView text = (TextView) view.findViewById(R.id.text);

    ImageView image = (ImageView) view.findViewById(R.id.image);
    CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);

    checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                        boolean isChecked) {
                    if (isChecked) {
                        // it is check
                    } else {
                        // it is unchecked
                    }
                }
            });



   text.setText((name.get(position)));
   imageLoader.DisplayImage(imageUrl.get(position), image);
   return view;
}