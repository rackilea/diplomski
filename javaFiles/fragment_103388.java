@Override     
protected void onPause() { 
  MyBeltegoed dialog = new MyBeltegoed (this, new OnReadyListenerBeltegoed()); 

  dialog.setContentView(R.layout.custom_dialog); <-- add this

  nieuwbel = (CheckBox)dialog.findViewById(R.id.nieuwbel); 
  Editor e = mPrefs.edit();   
  e.putBoolean(PREF_BOOL, nieuwbel.isChecked());           
  e.commit();          
  Toast.makeText(this, "Settings Saved.", Toast.LENGTH_SHORT).show();         
  super.onPause();    
}