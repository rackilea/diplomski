listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent mIntent = new Intent(CategoryGoster.this, DetailActivity.class);
        mIntent.putExtra("description",  elemanalicak.get(i).getResim());
        mIntent.putExtra("pic", elemanalicak.get(i).getDesc());
        startActivity(mIntent);
    }
});