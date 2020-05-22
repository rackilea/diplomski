public class EtMain extends TabActivity  {
    public WxFields  mDepWx;
    public WxFields  mArrWx;

    public void onCreate(Bundle savedInstanceState) {
        mDepWx = new WxFields(this);
        mArrWx = new WxFields(this);
    }
}

public class WxFields {
    private EtMain mParent; // Main Window object
    public int someField;

    public WxFields(EtMain myParent) {
        mParent = myParent;
    }

    public void someSetup() {
        Button mButton = (Button) mParent.findViewById(R.id.someRes); //<---mParent works here
        mParent.mArrWx.someField = 0;
    }
}