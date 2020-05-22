public class MainActivity extends Activity {

//Declare a class variable to use in this class
public <data-type> mContext;
public <data-type> mActivity;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = <Your value>;
        mActivity = <Your value>;

        myMethod (mContext , mActivity);

}
private void myMethod (<data-type> mContext, <data-type> mActivity) {
   /*
    Your Code Goes Here
  */
}
}