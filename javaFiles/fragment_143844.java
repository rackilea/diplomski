@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.item, null);

            // set value into textview
            TextView textView = (TextView) gridView.findViewById(R.id.label);
            textView.setText(this.textViewValues[position]);

            textView.setTextColor(Color.GREEN);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }