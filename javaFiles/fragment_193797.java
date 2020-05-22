Realm.Transaction myTr = new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Task newTask = realm.createObject(Task.class);
                        newTask.setText(myEditText.getText().toString());
                    }
                }, *** new Realm.Transaction.Callback(){
                    @Override
                    public void onSuccess() {
                        Log.d("REALM TASK", "saved successfully");
                    }

                    @Override
                    public void onError(Exception ignore) {
                        Log.d("REALM TASK", "not saved");
                    }
                };