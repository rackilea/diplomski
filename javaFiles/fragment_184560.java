Button mSaveButton = (Button) findViewById(R.id.saveButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ReportActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_for_percent , null);
                final EditText savingsDialog = (EditText) mView.findViewById(R.id.percentEditText);
                mBuilder.setView(mView)
                        .setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                Context context = getApplicationContext();
                                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();

                    SharedPreferences savings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = savings.edit();
                    editor.putString("percent", savingsDialog.getText().toString());
                    editor.commit();

                    updateSavingsView(Integer.parseInt(savingsDialog.getText().toString()));
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = mBuilder.create();
                dialog.show();
             }
            }
        });