listView.setOnItemClickListener(new OnItemClickListener(){
        private SparseArray<Boolean> hasClicked = new SparseArray<Boolean>();
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id){
            if (hasClicked.get(position, false)){
                v.setBackgroundColor(Color.RED);
                hasClicked.put(position, false);
            } else {
                v.setBackgroundColor(Color.GREEN);
                hasClicked.put(position, true);
            }
    }