@Override
public boolean onCreateOptionsMenu( Menu menu )
{
    super.onCreateOptionsMenu( menu );

    MenuItem searchMenuItem = menu.findItem( R.id.search_toolbar_main ); 
    searchMenuItem.expandActionView(); // Expand the search menu item in order to show by default the query

    return true;
}