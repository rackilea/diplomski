l1=(ListView)findViewById(R.id.list);
    l1.setAdapter(new dataListAdapter(t1, d1, s1));

    l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String selected = t1[position];
            Intent i = new Intent(getApplicationContext(), Main2Activity.class);
            i.putExtra("name", selected);
            startActivity(i);
        }
    });