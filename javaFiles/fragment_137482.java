public class FriendsListCursorAdapter extends CursorAdapter  {
    private Cursor cursor;
    ...
    public FriendsListCursorAdapter(Context context, Cursor c, boolean b) {
        super(context, c, true);
        cursor = c;
        con = context;
    }
    ...
}