public synchronized void setListener(Listener listener){
   mListener=listener;
}

public synchronized void fooFunction(){
   ...
   ...
   if (mListener!=null){
       mListener.notifyFoo();
   }
}