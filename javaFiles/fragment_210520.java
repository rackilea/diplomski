public class DataBoundAdapter extends CursorAdapter 
{
    Context _context;

    public DataBoundAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        _context = context;
    }

    @Override
    public void bindView(View view, Context c, Cursor cur) 
    {
        // TODO: handle data when binding to your list view
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) 
    {
        int item_view_id = R.layout.list_view_item;

        //inflate item view to list view holder
        LinearLayout holderView = new LinearLayout(_context);
        String inflaterName = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(inflaterName);
        inflater.inflate(item_view_id, holderView, true);

        return holderView;
    }
}