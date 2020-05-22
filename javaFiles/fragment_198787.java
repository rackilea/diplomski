public void run() {



//check some status of something here

runOnUiThread(new Runnable() {

            @Override
            public void run() {
                 textViewSomethingStatus.setText("hello world");//This will not give you crash now 

            }
        })