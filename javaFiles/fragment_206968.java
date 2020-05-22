private MyService extends Service {
    Handler mHandler=new Handler();
    //...

    public void runa() throws Exception{
        mHandler.post(new Runnable(){
            public void run(){
                Toast.makeText(MyService.this, "test", Toast.LENGTH_LONG).show()
            }
        }
    }    
}