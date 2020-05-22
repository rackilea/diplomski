@Override
public void onDestroy() {
    super.onDestroy();
    if(myReceiver != null){
        try{
            unregisterReceiver(myReceiver);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}