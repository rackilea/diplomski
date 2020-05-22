new Handler().post(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(ActivityMain.this,"Message",Toast.LENGTH_LONG).show();
        }
    });