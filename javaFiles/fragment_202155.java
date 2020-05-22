@Click
void button1(View view) {
  startProcess();
}

void startProcess() {
  if(progressBar !=null) // progressBar should be a field in your Activity / Fragment
      progressBar.setVisibility(ProgressBar.VISIBLE);


  button1.setEnabled(false);
  if(progressBar !=null)
      progressBar.setVisibility(ProgressBar.INVISIBLE);
  textView1.setText("DOWNLOADING...");

  yourBackgroundMethod();
}

@Background
void yourBackgroundMethod() {
  URL u;
  InputStream is;

  try
  {
      u = new URL( adres);
      is = u.openStream();
      Bitmap temp = BitmapFactory.decodeStream(is);
      bmp=temp.copy(Bitmap.Config.ARGB_8888, true);

      onBackgroundSuccess();
      onBackgroundTerminate();
  }
  catch( Exception e)
  {
      onBackgroundError();
      onBackgroundTerminate();
  }
}

@UiThread
void onBackgroundError() {
  imageView.setImageBitmap(bmp);
  imageView1.setImageBitmap(bmp);
  imageView2.setImageBitmap(bmp);
  imageView3.setImageBitmap(bmp);
  imageView4.setImageBitmap(bmp);
  imageView5.setImageBitmap(bmp);
  imageView6.setImageBitmap(bmp);
  imageView7.setImageBitmap(bmp);
  imageView8.setImageBitmap(bmp);

  textView1.setText("Downloading finished");
}

@UiThread
void onBackgroundSuccess() {
  textView1.setText("Error when downloading");
}

@UiThread
void onBackgroundTerminate() {
  button1.setEnabled(true);
  progressBar.setVisibility(ProgressBar.INVISIBLE);
}