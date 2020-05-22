lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
        onListItemClick(v,pos,id);
    }
});