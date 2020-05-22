public void login(int id)
        {
runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(), "OK LOGGED IN",Toast.LENGTH_LONG).show();

                        }
                    });

        }