privateBtnGetCapture.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pictureBitmap = privateTextureView.getBitmap();
            AsyncTask<Bitmap, Bitmap, Bitmap> myTask = new ApplyFilterTask();
            //Start MyTask
            myTask.execute(pictureBitmap);
        }
    });