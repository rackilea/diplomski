ProgressDialog barProgressDialog;
Handler updateBarHandler;

public void launchBarDialog(View view) {
    updateBarHandler = new Handler();
    barProgressDialog = new ProgressDialog(MainActivity.this);
    barProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

        @Override
        public void onDismiss(DialogInterface dialog) {
            //Put your AlertDialog Here ....
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setMessage("This Alert Dialog will be show after the ProgressDialog dismissed");
            alert.show();

        }
    });
    barProgressDialog.setTitle("Processing,please wait ...");
    barProgressDialog.setMessage("Cracking password in progress ...");
    barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
    barProgressDialog.setProgress(0);
    barProgressDialog.setMax(10);
    barProgressDialog.show();

    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // Here you should write your time consuming task...
                while (barProgressDialog.getProgress() <= barProgressDialog
                        .getMax()) {

                    Thread.sleep(1000);
                    updateBarHandler.post(new Runnable() {
                        public void run() {
                            barProgressDialog.incrementProgressBy(2);

                            if (barProgressDialog.getProgress() == barProgressDialog
                                    .getMax()) {
                                barProgressDialog.dismiss();
                            }
                        }
                    });
                }
            } catch (Exception e) {
                Log.e("thiago", "error when trying to run the Thread==>"+e.getMessage());
            }
        }
    }).start();
}