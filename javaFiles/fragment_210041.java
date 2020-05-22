public interface MyLibrary extends Library { /* StdCallLibrary if using __stdcall__ */
    interface MyCallback extends Callback { /* StdCallCallback if using __stdcall__ */
        void invoke(/* fill your parameters here*/); 
    }
    DWORD RegisterCallback(HANDLE handle, int type, MyCallback callback);
}

...
MyLibrary lib = (MyLibrary)Native.loadLibrary("mylib", MyLibrary.class/*, options*/);
MyCallback callback = new MyCallback() {
    public void invoke() {
        System.out.println("Success!");
    }
};
HANDLE h = ...;
int type = ...;
lib.RegisterCallback(h, type, callback);
...