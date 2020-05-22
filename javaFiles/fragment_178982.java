Button buy = (Button) findViewById(R.id.delete);
buy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        for (int i = 0; i < yourList.size(); i++){
            File ff = new File(Environment.getExternalStorageDirectory().toString() + "/TestApp/" + yourList.get(i));
            ff.delete();
        }

        // Clear your list here
        yourList.clear();
        // And remove the following line
        // adapter.remove(adapter.getItem(i));
        adapter.notifyDataSetChanged();
    }
}