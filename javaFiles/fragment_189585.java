class XXX {
   final Runnable callback = new Runnable() {
       @Override
       public void run() {
           dosomething1();
       } 
    };
    Config c=new Config(callback);
}