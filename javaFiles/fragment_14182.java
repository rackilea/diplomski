class A implements ICallback {
     MyObject o;
     B b = new B(this, someParameter);

     @Override
     public void callback(MyObject o){
           this.o = o;
     }
}

class B {
     ICallback ic;
     B(ICallback ic, someParameter){
         this.ic = ic;
     }

    new Thread(new Runnable(){
         public void run(){
             // some calculation
             ic.callback(myObject)
         }
    }).start(); 
}

interface ICallback{
    public void callback(MyObject o);
}