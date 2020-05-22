public void setFileSize(View view, long fileSize) {
    String sizeOfFile = readableFileSize(fileSize);

    size = (TextView)view.findViewById(R.id.size);

    size.setText("Size: " + sizeOfFile);
  }

  public void setProgressBar(View view,int a) {
    holder.progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
    progressBar.setProgress(a);
  }

  public void setTextProgress(View view,String a) {
    progress = (TextView)view.findViewById(R.id.progress);
    progress.setText(a);
  }