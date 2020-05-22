listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String data = adapter.get(position);
            Toast.makeText(Main2Activity.this,data,Toast.LENGTH_SHORT).show();
        }
    });