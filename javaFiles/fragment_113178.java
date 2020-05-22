@Override
public void onBackPressed()
{
     // code here depending on your needs
    ActivityCompat.finishAffinity(this);
    finish();
}