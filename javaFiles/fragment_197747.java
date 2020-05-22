lv = findViewById(R.id.listView);
lv.setAdaptater(adapter);
final ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, list) {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the current item from ListView
            View view = super.getView(position, convertView, parent);

            // Set the text color of TextView (ListView Item)
            TextView tv = view.findViewById(android.R.id.text1);
            // Generate ListView Item using TextView
            tv.setTextColor(Color.parseColor("#efefef"));
            tv.setTextSize(20);
            tv.setAllCaps(true);

                // Set a background color for ListView
                view.setBackgroundColor(Color.parseColor("#00afd8"));

            return view;
        }
    };
    lv.setAdapter(adapter);