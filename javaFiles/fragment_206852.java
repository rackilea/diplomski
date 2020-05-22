public AlertDialog alertDialog;

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectUser);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Main3Activity.this, android.R.layout.simple_list_item_1, userList);
        lvUser.setAdapter(arrayAdapter);
        builder.setView(lvUser);

        //when user selects item
        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = userList.get(position);
                int userID;
                userID = tmDB.getUserId(name);
                txtName.setText(name);
// close the list view after selecting an item
                alertDialog.dismiss();

            }
        });

        alertDialog = builder.create();
        alertDialog.show();