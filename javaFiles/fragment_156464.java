public void setImagePath(String path,int position){ //GETTING IMAGE HERE FROM ONACTIVITYRESULT TO THIS ADAPTER
this.ImageData=path;
userGridList.get(position).setUpload(true);
Log.d(TAG,"Position of Grid "+position); //POSITION OF CLICKED ITEM
Log.d(TAG,"Set Image Path "+path);    //IMAGE PATH OF SELECTED IMAGE
notifyDataSetChanged();
}