liveView = new Dialog(myView.this, R.style.Dialog);
        liveView.setContentView(R.layout.liveview_dialogue);
        TextView title = (TextView)liveView.findViewById(R.id.liveViewTitle);           
        Button button = (Button) liveView.findViewById(R.id.liveViewButton);
        trackImage = (ImageView)liveView.findViewById(R.id.liveViewImage);





        button.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                run = false;
                liveView.dismiss();
            }
        });
        liveView.show();

        final Handler handler = new Handler(); 
        final Runnable r = new Runnable()
        {
            Iterator<Bitmap> it = images.iterator();
            public void run() 
            {   
                if(run){
                trackImage.setImageBitmap(it.next());
                if(it.hasNext())
                handler.postDelayed(this, 5000);
                }
            }
        };
        handler.postDelayed(r, 5000);