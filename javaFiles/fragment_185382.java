add_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Create item list");
            final EditText enter_item_list=new EditText(MainActivity.this);
            enter_item_list.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
            enter_item_list.setHint("Type a name");
            enter_item_list.setHintTextColor(Color.RED);
            builder.setView(enter_item_list);

            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String item_name = enter_item_list.getText().toString().trim();
                    add_item_to_list(item_name);

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.dismiss();



                }
            });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();
            itemList_ref = Firestore_ref.collection("itemList").document(UserEmail).collection("user_item_list");
        }
    });