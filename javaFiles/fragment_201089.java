@override
 protected void onCreate(){
       super.onCreate();
       ...
       if(Singleton.getInfo() == null){
        this.finish();
        startActivity(...)
       }
 }