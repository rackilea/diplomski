@Override
public boolean onOptionsItemSelected(MenuItem item)
    {
    switch(item.getItemId())
       {
        case R.id.display_toast:
            displayContent(content);
            }
            return true;
        default:
            return super.onOptionsItemSelected(item);          
     }