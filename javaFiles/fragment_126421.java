listView.setOnItemLongClickListener(new OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
            int arg2, long arg3) {
        Toast.makeText(arg0.getContext(),     ((TextView)arg1).getText(), Toast.LENGTH_SHORT).show();
        return false;
    }
 });

listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> listView, View itemView, int index,
            long id) {
    }
});