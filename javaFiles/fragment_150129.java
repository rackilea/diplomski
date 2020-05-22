lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id) {
            return onLongListItemClick(v,pos,id);
        }
    });