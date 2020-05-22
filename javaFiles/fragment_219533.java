class YourPage extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Signal that this fragment has proper actions
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) 
    {
        super.onCreateOptionsMenu(menu, inflater);

        // The menu will be added to the action bar
        inflater.inflate(R.menu.fragment_page_menu, menu);      
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_refresh:
            {
                // Handle the action...

                return true;
            }


            default:
                return super.onOptionsItemSelected(item);
        }       
    }   
}