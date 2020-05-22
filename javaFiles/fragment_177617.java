listView.setOnItemLongClickListener(new OnItemLongClickListener() {

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view,
            int position, long arg3) {

              adapter.remove(data[position]);//position of the item you click
              adapter.notifyDataSetChanged();

        return false;
    }

});