final int RETRY_DELAY=100;
new Handler(){
    public void handleMessage(Message msg){
       if (msg.what<0) return; //something went wrong and retries expired
               lv=getListView();
       for (int i=0;i <lv.getChildCount();i++){
         if (((TextView)lv.findViewById(R.id.my_hidden_textview)).getText.equals(mykey)){
            //result = lv.findViewById(R.id.my_hidden_textview);
         } else {
            this.sendEmptyMessageDelayed(msg.what-1,RETRY_DELAY);
         }
       }     
    }
}.sendEmptyMessageDelayed(10,RETRY_DELAY);