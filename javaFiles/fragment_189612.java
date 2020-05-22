// Java code
public class MyCustomClassJNI implements UpdateCallback {

    public native void notifyJni(MyClass data);

    @Override
    void OnDataUpdate(MyClass data) {
        this.notifyJniPeer(data);
    }
}