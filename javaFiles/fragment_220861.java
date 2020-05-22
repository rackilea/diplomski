///... your code here..

    new Thread(new Runnable() {

        @Override
        public void run() {

            Your_Current_Activity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {

                dialog.cancel();

                // START ACTIVITY HERE
               Your_Current_Activity.this.startActivity(new 
                        Intent(Your_Current_Activity.this,
                                       PdfGenerator.class));

                }
            });

        }

    }).start();