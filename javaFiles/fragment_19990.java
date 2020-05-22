@Override
public void onBackPressed(){
   if(resultImageView.getVisibility == View.VISIBLE){
      resultImageView.setVisibility(View.INVISIBLE); //or GONE 
      result.setVisibility(View.INVISIBLE);
   }else{
      finish();
   }
}

@Override
public void run() {
   [...]
   resultImageView.setVisibility(View.VISIBLE);
   result.setVisibility(View.VISIBLE);
   [...]
}