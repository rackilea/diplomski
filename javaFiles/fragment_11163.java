lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent in = new Intent(this, OndernemingDetailActivity.class);
            //Send onderneming
            in.putExtra("selected_onderneming", adapter.getItem(i));
            startActivity(in);
        }
    });