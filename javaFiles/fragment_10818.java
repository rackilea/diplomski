private Object monitor = new Object();

public void setListener(Listener listener){
   synchronized (monitor) {
       mListener=listener;
   }
}

public void fooFunction(){
   ...
   ...
   synchronized (monitor) {
        if (mListener!=null){
           mListener.notifyFoo();
       }
   }
}