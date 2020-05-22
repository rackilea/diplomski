public class PackageNameHelper
{
    private Context mContext;

    public PackageNameHelper(Context context)
    {
        mContext = context;
    }

    public String GetPackageName(){
        return mContext.getPackageName();
    }

}