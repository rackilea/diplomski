gridView.setAdapter(customAdopter);
customAdopter.setItemClickListener(new ItemClickListener() {
        @Override
        public void onItemClick(int position) {
            Intent intent = new Intent(MainActivity.this, SwipeView.class);
            intent.putExtra("id", position);
            startActivity(intent);
        }
    });