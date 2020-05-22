InputStream is=...;
byte[] bytes=new byte[1028];
while(is.read(bytes)!=-1) {
Thread t1=new Thread(new Runnable() {
        @Override
        public void run() {
          log(bytes); //call function to log
        }
    });
Thread t2=new Thread(new Runnable() {
        @Override
        public void run() {
           parse(bytes);//call function to parse
        }
    });
     t1.start();
     t2.start();
try {
     t1.join();
     t2.join();
    }catch(Exception ex) {
      ex.printStackTrace();
    }
}