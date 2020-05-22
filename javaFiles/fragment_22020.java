public class Demo {
    native void nativeEntry();
    Adder mAdder = new Adder();

    public static void main(String[] args){
            System.loadLibrary("JNIBridge");

            Demo demo = new Demo();         
            demo.nativeEntry();
    }
}