public void switchViews() {
  if(mMainView.getVisibility() == View.VISIBLE){
     mMainView.setVisibility(View.GONE);
     mGLView.setVisibility(View.VISIBLE);
  } else{
     mMainView.setVisibility(View.VISIBLE);
     mGLView.setVisibility(View.GONE);
  }
}