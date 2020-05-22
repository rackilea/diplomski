public MyObject implements AutoCloseable{
     // ...
     @Override
     close(){
     //cleans up resources utilized by this object.
     }
}


public static void main(String[] args) {
   try(MyObject my = new MyObject();){
        my.method1();
        my.method2();
   } // calls 'close()' when leaving this block even when exception occures
}