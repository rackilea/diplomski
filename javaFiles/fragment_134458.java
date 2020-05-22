capturePicture.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

      myAsyncTask task=new myAsyncTask();
      task.doInBackground();
      task.execute();


        }

    });