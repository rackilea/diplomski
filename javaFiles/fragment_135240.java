shareButton.setOnClickListener(new OnClickListener() {
                            public void onClick(View v) {


                                AlertDialog.Builder al1 = new Builder(
                                        AgriListView.this);
                                al1.setMessage("Share Something");

                                al1.setPositiveButton("Share",
                                        new DialogInterface.OnClickListener() {

                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {

                                                final EditText input = new EditText(
                                                        AgriListView.this);
                                                input.setSingleLine();

                                                AlertDialog.Builder al = new Builder(
                                                        AgriListView.this);
                                                al.setTitle("Enter New Value");
                                                al.setView(input);
                                                al.setCancelable(true);
                                                al.setIcon(R.drawable.bt);
                                                al.setPositiveButton(
                                                        "OK",
                                                        new DialogInterface.OnClickListener() {

                                                            public void onClick(
                                                                    DialogInterface dialog,
                                                                    int which) {

                                                                int len = input
                                                                        .length();

                                                                if (!(len == 0)) {

                                                                    Toast.makeText(
                                                                            AgriListView.this,
                                                                            "Entered text is: "+input.getText()
                                                                                ,
                                                                            Toast.LENGTH_SHORT)
                                                                            .show();

                                                                } else {

                                                                    Toast.makeText(
                                                                            getApplicationContext(),
                                                                            "Enter Value Properly",
                                                                            Toast.LENGTH_LONG)
                                                                            .show();
                                                                }
                                                            }

                                                        });

                                                al.setNegativeButton(
                                                        "Cancel",
                                                        new DialogInterface.OnClickListener() {

                                                            public void onClick(
                                                                    DialogInterface dialog,
                                                                    int which) {
                                                                dialog.cancel();
                                                            }
                                                        });

                                                AlertDialog alert = al.create();
                                                alert.show();
                                            }
                                        });

                                al1.setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener() {

                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                dialog.cancel();

                                            }
                                        });

                                AlertDialog alert1 = al1.create();
                                alert1.show();
                            }

                        });