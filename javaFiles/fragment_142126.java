findViewById(R.id.capture).setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View v) {
                 Thread td = new Thread(new Runnable() {
                   public void run()
                   {
                         Bitmap bmp =  mTextureView.getBitmap();  
                         rev = new ArrayList<Bitmap>();
                         rev.add(bmp);
                         runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                 Toast.makeText(getApplicationContext(),""+ rev.size(), Toast.LENGTH_LONG).show();
                            }
                        });
                   }
                 });
                 td.start(); //start the thread

               }
            });