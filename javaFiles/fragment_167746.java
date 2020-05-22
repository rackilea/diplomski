AdapterInterface buttonListener;

public MyListAdapter (Context context, Cursor c, int flags, AdapterInterface buttonListener)
{
  super(context,c,flags);
  this.buttonListener = buttonListener;
}