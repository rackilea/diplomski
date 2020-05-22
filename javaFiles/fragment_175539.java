public class ProfileList extends ListActivity
{
    private ArrayList<Profile> profilesArrayList;
    @Override 
    public void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        //populate your arraylist

        setListAdapter ( new ArrayAdapter<Profile>() );
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Log.d("cardNumber", profilesArrayList.get(position).getCardNumber());
    }
}