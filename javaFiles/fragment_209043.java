@Override
   public View getView(final int position,  View convertView, ViewGroup parent) {
        Log.e("sara" , "this part takes time");


        LayoutInflater inflater = getLayoutInflater();


        convertView = getLayoutInflater().inflate(R.layout.gallery_gridsq, parent, false);
      ImageView  iv = (ImageView) convertView.findViewById(R.id.icon);
       File file = new File(Uri.parse(getItem(position).toString()).getPath());
        new myTask(iv, file).execute();


        return convertView;
    }


            private class MyTask extends AsyncTask <Void , Void ,Bitmap> {
               Imageview iv;
                File file;
             public void MyTask(Imageview iv, File file)
                 {
                   this.iv=iv;
                   this.file= file;
                  }
                @Override
                protected Bitmap doInBackground(Void... params) {

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    try {
                        BitmapFactory.decodeStream(new FileInputStream(file), null, options);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    options.inJustDecodeBounds = false;
                    options.inSampleSize = 2;
                    try {
                        bmp = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return bmp;
                }


                @Override
                protected void onPostExecute(Bitmap aVoid) {

                    iv.setImageBitmap(aVoid);
                }
            }