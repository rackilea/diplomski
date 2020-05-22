@Override
public void onRestart()
{
    super.onRestart();
     recreate();
    finish();
    overridePendingTransition(0, 0);
    startActivity(getIntent());
    overridePendingTransition(0, 0);
}