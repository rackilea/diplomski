count = 0;
    progressDialog = new ProgressDialog(this, getProgressDailogStyle());
    progressDialog.setMessage("Processing ...");
    progressDialog.show();
    progressDialog.setCancelable(false);

    new CountDownTimer(10000, 2000) {

        public void onTick(long millisUntilFinished) {
            //here you can have your logic to set message
            count=count+1;
            if (count==1){
                progressDialog.setMessage("Processing 1");
            }else if (count==2){
                progressDialog.setMessage("Processing 2");
            } 
              // until the count = 5 


        }

        public void onFinish() {
            //the progress is finish
            count = 0;
            progressDialog.dismiss();

        }

    }.start();