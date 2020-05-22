@Override
public boolean onMenuItemSelected(int featureId, MenuItem item){
  switch(item.getItemId()){
  case R.id.miPrefs:
    startActivity(new Intent().setClass(this,Prefs.class));
    break;
  }
}