@Override
public void onRemoveClick( int position )
{
    Log.d( "RecycleViewTest", "Remove at Position: " + position );
    itemList.remove( position );
    adapter.notifyItemRemoved( position );
}