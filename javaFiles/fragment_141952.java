@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_circle_activity);
        progressBar = new ProgressDialog(ProgressCircleActivity.this);
        progressBar.setMessage("Please wait ...");
        progressBar.setCancelable(true);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                        Thread.sleep(3*1000);
                        Intent i=new Intent(ProgressCircleActivity.this,PhoneNumberLogin.class);
                        startActivity(i);//dismiss the progressdialog
                        progressBar.dismiss();
                        //Remove activity
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
            }).start();
    }