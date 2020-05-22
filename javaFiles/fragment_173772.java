private SparseBooleanArray checkedPositions = new SparseBooleanArray();// class variable


listView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
             if(checkedPositions.get(position)){
                 checkedPositions.put(position, false);
             }else{
                 checkedPositions.put(position, true);
             }
        }

    });