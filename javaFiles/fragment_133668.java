@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
    case R.id.action_setting:
        if(myBoolean){
           findViewById(R.id.checkBox).setVisibility(View.GONE);
           myBoolean = false;
        }else{
           findViewById(R.id.checkBox).setVisibility(View.VISIBLE);
           myBoolean = true;
        }
        return true;
    default:
        return super.onOptionsItemSelected(item);
    }
}