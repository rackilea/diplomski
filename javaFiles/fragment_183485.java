autoTextView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View arg1, int pos,
                long id) {
             Editable message = autoTextView.getText();

             String  item_name    = message.toString();

              String item_id = map_name_value.get(item_name);
               //your stuff
           }
    });

 //item_name is name of institute
 // item_id is id of institute