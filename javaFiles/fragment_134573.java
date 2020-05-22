public interface MyDll extends Library{
  MyDll INSTANCE = (MyDll) Native.loadLibrary("MyDll",MyDll.class);
     public interface MyCallback extends Callback {
            public boolean callback(String msg);
     }
     public int Start(MyCallback callback);
  }