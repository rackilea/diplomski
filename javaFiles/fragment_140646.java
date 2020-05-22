ProgressDialog progress = new ProgressDialog(getApplicationContext());
progress.setTitle("In Progress");
progress.show();

AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //Do things.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Update UI.
                    }
                });
                //Do things.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.dismiss();
                    }
                });
            }
        });

progress.setOnDismissListener(newDialogInterface.OnDismissListener() 
            {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                //Called after your background task ended.
            }
        });