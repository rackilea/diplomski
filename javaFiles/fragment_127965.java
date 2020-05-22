lv.setOnItemLongClickListener(new OnItemLongClickListener() {

        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                int pos, long id) {
            // TODO Auto-generated method stub

            //do what you want to do.
            //If you want to delete that entry.
            lv.remove(arg2);//where arg2 is position of item you click
            myAdapter.notifyDataSetChanged();

            return true;
        }
    });