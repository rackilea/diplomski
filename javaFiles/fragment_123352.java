public class OtherClass {

    Context mContext;

    public void init(Context context){
      mContext = context;
    }
    ...

mContext.startService(new Intent(mContext, SomeService.class));