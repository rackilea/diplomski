listView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view
                                                , int position,long id) {
      Log.i("mm", " onItemClick ");
      Intent intent=new Intent(GroupActivity.this,ListViewGroup.class);

      GroupActivity.this.startActivity(intent);
    }

 });