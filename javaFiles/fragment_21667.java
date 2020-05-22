listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {

            String  myUrl = urHashMaparraylist.get(position).get("videolocation");
            Intent n = new Intent(YourActivityName.this , NewActivityName.class);
            n.putExtra("videolocation",myUrl);
            startActivity(n);

        }

    });