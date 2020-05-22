listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          Word word = words.get(i); // it's the selected word
          Intent intent = new Intent(CurrentActivity.this, DetailsActivity.class);
          intent.putExtra("word", word);
          startActivity(intent);
        }
    });