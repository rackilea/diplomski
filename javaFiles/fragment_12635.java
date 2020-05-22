list.setOnItemClickListener(new OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {


   Toast.makeText(getBaseContext(),videolist.get(position).getuser(),Toast.LENGTH_SHORT).show();
    }
});