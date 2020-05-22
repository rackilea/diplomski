ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(
              getActivity(),
              R.layout.row_item, R.id.text ,
              faList
       );
 listView.setAdapter(listviewAdapter);