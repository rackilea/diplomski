@Override
public void onBackPressed() {
    // TODO Auto-generated method stub
    super.onBackPressed();

    Intent newIntent = new Intent(ProfileMaker.this, Monitor.class);
newIntent.putExtra("somename",state of the radiobutton);
    startActivity(newIntent);
}