list.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
            HashMap<String,String> item = (HashMap<String,String>) adapter.getItem(position);
            Intent intent = new Intent(this, YourSecondActivity.class);
            intent.putExtra("TAG_ID_RS", item.get("TAG_ID_RS"));
            intent.putExtra("TAG_NAMA_RS", item.get("TAG_NAMA_RS"));
            ......
            startActivity(intent);
        }
    });