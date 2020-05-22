auto1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            Toast.makeText(MainActivity.this,
                    adapter.getItem(position).toString(),
                    Toast.LENGTH_SHORT).show();
        }
    });