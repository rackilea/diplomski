mListView.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
                  int position, long id) {

              Toast.makeText(getApplicationContext(), " ITEM CLICKED POSITION = "+String.valueOf(position), Toast.LENGTH_SHORT).show();   
              }
            });