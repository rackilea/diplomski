public class statusBlock {
    /* A Java representation of a Status Block */
    private long errcode = 0;
    private long errref = 0;
    private String errmsg = "";
    private long[] TmidArray;
    private long evt_id = 0;
    private short IgViolation_severity = 0;
}

public class MyFunkyJNIClass {
    private Object response;

    /**
     * To generate the C-header for a native call use: javah -jni
     * example.package.MyFunkyJNIClass from target/classes folder.
     */
    private native int nativeExecuteFunction(int callType, Object payload, Object response);

    public MyFunkyJNIClass() {
        System.loadLibrary("theCLibrary");
    }
}