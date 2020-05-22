listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                 if(((TextView) view).getText().toString().equals("Blue")){
                    //Call Blue activity
                }else if(((TextView) view).getText().toString().equals("Red")){
                    //Call Red activity
                }
            }
        });