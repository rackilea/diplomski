lv.setOnItemClickListener(new OnItemClickListener()
        {
        public void onItemClick(AdapterView<?> arg0,View arg1,int arg2, long arg3){
            ListView lv = (ListView) findViewById(R.id.listView1);      
            final String Name = lv.getAdapter().getItem(arg2).toString();               

            // Make sth on click
        }});


        lv.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    final int arg2, long arg3) {
            // Make sth on longclick
            return true;
            }
        });