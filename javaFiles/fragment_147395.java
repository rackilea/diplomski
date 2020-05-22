ArrayList<String> arr = new ArrayList<>();

    arr.add(String.format("%-10s", "aaaaaa") + "10");
    arr.add(String.format("%-10s", "aa") + "10");
    arr.add(String.format("%-10s", "asdkaosds") + "10");
    arr.add(String.format("%-10s", "aaaaaaaaaa") + "10");
    final Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/DroidSansMono.ttf");

    ArrayAdapter<String> itemsAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr){
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            TextView item = (TextView) super.getView(position,convertView,parent);

            item.setTypeface(mTypeface);

            return item;
        }
    };
    ListView listView = findViewById(R.id.answers);

    listView.setAdapter(itemsAdapter);