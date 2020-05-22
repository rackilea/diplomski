Use this..

    lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
              // When clicked, show a toast with the TextView text
String str_item = lv.getItemAtPosition(position).toString();
              Toast.makeText(getApplicationContext(), str_item,
                  Toast.LENGTH_SHORT).show();
       }
    }