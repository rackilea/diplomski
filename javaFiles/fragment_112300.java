@Override
public boolean onOptionsItemSelected(MenuItem item) {    
    // Handle presses on the action bar items    
    switch (item.getItemId()) {        
        case R.id.action_search:            
            openSearch();            
            return true;        
        case R.id.action_compose:            
            composeMessage();            
            return true;        
        default:            
            return super.onOptionsItemSelected(item);    
    }
}