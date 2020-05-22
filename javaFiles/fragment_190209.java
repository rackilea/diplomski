@Override
public boolean onOptionsItemSelected(MenuItem item) 
{

    switch (item.getItemId())
    {
        case R.id.action_bar:
            Log.i(TAG, "Action bar item clicked");
            return true;
        case R.id.home:
            Log.i(TAG, "Home item clicked");
            return true;
        case R.id.logout: {
            Log.i(TAG, "Logout item clicked");

            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);

            return true;
        }

        default:
            return super.onOptionsItemSelected(item);
    }
}