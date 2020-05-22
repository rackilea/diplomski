public void onClick(DialogInterface dialog, int id) 
                                   {
                                    myDB = new DatabaseHelper1(getContext());
                                    myDB.deleteItem(user.getBillID());
                                    users.remove(position);
                                    notifyDataSetChanged();

                                    }