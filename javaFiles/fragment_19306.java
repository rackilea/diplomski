private Handler handler = new Handler();
Runnable updatePage = new Runnable() {
                @Override
                public void run() {

                    // do what you want in here (calling your web service request)                    


                    handler.postDelayed(updatePage,1000);
                }
            };