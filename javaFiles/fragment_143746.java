public class MyUtils {

    private Context mContext;

    public MyUtils(Context context) {
        mContext = context;
    }

    public void displayToast(String message, int lenght){
        if (lenght == 0){
            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
        }
    }
}