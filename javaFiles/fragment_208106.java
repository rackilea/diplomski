public class ParserArrayList {
    Context mContext;
    ...

    public ParserArrayList(Context context) { 
        mContext = context;
        ... 
    }

    public void showData(){
        sqlAdapter = new SQLiteAdapter(mContext);
        ...
    }
}