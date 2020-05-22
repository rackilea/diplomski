final String text = myEditText.getText().toString();
                realm.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Task newTask = realm.createObject(Task.class);
                        newTask.setText(text);
                    }
                }, new Realm.Transaction.Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("REALM TASK", "saved successfully");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("REALM TASK", "not saved", e);
                    }
                });