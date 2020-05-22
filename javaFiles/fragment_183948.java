@Override
public void onStop() {
 super.onStop();
   if(handler!=null){
       handler.removeCallbacks(job);
   }
}